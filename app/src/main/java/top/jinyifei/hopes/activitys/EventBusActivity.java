package top.jinyifei.hopes.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.models.MyEvent;

public class EventBusActivity extends AppCompatActivity {

    private String TAG="ceshi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        //注册事件总线
        EventBus.getDefault().register(this);
    }

    /**
     * 在主线程中发布事件
     * @param view
     */
    public void onPublishEventOnMainThread(View view) {
        MyEvent event = new MyEvent("主线程的消息");
        EventBus.getDefault().post(event);
    }

    /**
     * 在子线程中发送事件
     * @param view
     */
    public void onPublishEventOnBGThread(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyEvent event = new MyEvent("后台线程的消息");
                EventBus.getDefault().post(event);
            }
        }).start();
    }

    /**
     * POSTING线程模型：在哪个线程发布事件，就在哪个线程执行onPostingEvent方法
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onPostingEvent(MyEvent event) {
        Log.d(TAG, "onPostingEvent:" + Thread.currentThread().getName());
    }


    /**
     * MAIN线程模型：不管是哪个线程发布事件，都在主线程执行onMainEvent方法
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEvent(MyEvent event) {
        Log.d(TAG, "onMainEvent: " + Thread.currentThread().getName());
    }

    /**
     * BACKGROUND线程模型：事件如果是在子线程发布，onBackgroundEvent方法就在该子线程执行，事件如果是在
     * 主线程中发布，onBackgroundEvent方法就在EventBus内部的线程池中执行
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onBackgroundEvent(MyEvent event) {
        Log.d(TAG, "onBackgroundEvent: " + Thread.currentThread().getName());
    }

    /**
     * ASYNC线程模型：不管事件在哪个线程发布，onAsyncEvent方法都在EventBus内部的线程池中执行
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onAsyncEvent(MyEvent event) {
        Log.d(TAG, "onAsyncEvent: " + Thread.currentThread().getName());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册事件总线
        EventBus.getDefault().unregister(this);
    }
}
