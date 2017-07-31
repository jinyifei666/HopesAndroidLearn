package top.jinyifei.hopes.activitys;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.models.ChartEntity;
import top.jinyifei.hopes.view.LineChart;

public class MqttActivity extends AppCompatActivity {

    private TextView resultTv;

    private String host = "tcp://118.89.54.55:1883";
    private String userName = "admin";
    private String passWord = "jin4yi5fei6";
    private int i = 1;

    private Handler handler;
    private LineChart lineChart;

    private MqttClient client;
    List<ChartEntity> data;
    private String myTopic = "topic/data";

    private MqttConnectOptions options;
    private static int index=0;

    private ScheduledExecutorService scheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt);
        lineChart = (LineChart) findViewById(R.id.chart);
        data = new ArrayList<>();
        data.add(new ChartEntity(String.valueOf(index),Float.valueOf(0)));
        lineChart.setData(data);
        init();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    Toast.makeText(MqttActivity.this, (String) msg.obj,
                            Toast.LENGTH_SHORT).show();
                    index++;
                    Log.w("message",(String)msg.obj);
                    data.add(new ChartEntity(String.valueOf(index), Float.valueOf(String.valueOf(msg.obj))));
                    lineChart.setData(data);
                    lineChart.invalidate();

//                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                    Notification notification = new Notification(R.drawable.icon, "Mqtt即时推送", System.currentTimeMillis());
//                    notification.contentView = new RemoteViews("com.hxht.testmqttclient", R.layout.activity_notification);
//                    notification.contentView.setTextViewText(R.id.tv_desc, (String) msg.obj);
//                    notification.defaults = Notification.DEFAULT_SOUND;
//                    notification.flags = Notification.FLAG_AUTO_CANCEL;
//                    manager.notify(i++, notification);


                } else if (msg.what == 2) {
                    System.out.println("连接成功");
                    Toast.makeText(MqttActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                    try {
                        client.subscribe(myTopic, 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (msg.what == 3) {
                    Toast.makeText(MqttActivity.this, "连接失败，系统正在重连", Toast.LENGTH_SHORT).show();
                    System.out.println("连接失败，系统正在重连");
                }
            }
        };

        startReconnect();

    }

    private void startReconnect() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                if (!client.isConnected()) {
                    connect();
                }
            }
        }, 0 * 1000, 10 * 1000, TimeUnit.MILLISECONDS);
    }

    private void init() {
        try {
            //host为主机名，test为clientid即连接MQTT的客户端ID，一般以客户端唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(host, "test",
                    new MemoryPersistence());
            //MQTT的连接设置
            options = new MqttConnectOptions();
            //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            //设置连接的用户名
            options.setUserName(userName);
            //设置连接的密码
            options.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            //设置回调
            client.setCallback(new MqttCallback() {

                @Override
                public void connectionLost(Throwable cause) {
                    //连接丢失后，一般在这里面进行重连
                    System.out.println("connectionLost----------");
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    //publish后会执行到这里
                    System.out.println("deliveryComplete---------"
                            + token.isComplete());
                }

                @Override
                public void messageArrived(String topicName, MqttMessage message)
                        throws Exception {
                    //subscribe后得到的消息会执行到这里面
                    System.out.println("messageArrived----------");
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = topicName + "---" + message.toString();
                    handler.sendMessage(msg);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    client.connect(options);
                    Message msg = new Message();
                    msg.what = 2;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    Message msg = new Message();
                    msg.what = 3;
                    handler.sendMessage(msg);
                }
            }
        }).start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (client != null && keyCode == KeyEvent.KEYCODE_BACK) {
            try {
                client.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            scheduler.shutdown();
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
