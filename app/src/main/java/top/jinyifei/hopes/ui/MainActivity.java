package top.jinyifei.hopes.ui;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import top.jinyifei.hopes.R;


/**
 * 新的运行时权限检测机制仅作用于TargetSdkVersion大于等于23的情况
 * <p>
 * 新的权限机制将权限分为普通权限和危险权限，仅危险权限需要通过代码动态去申请。
 * <p>
 * 危险权限包括:
 * <p>
 * 身体传感器
 * 日历
 * 摄像头
 * 通讯录
 * 地理位置
 * 麦克风
 * 电话
 * 短信
 * 存储空间
 * <p>
 * CALENDAR : READ_CALENDAR WRITE_CALENDAR
 * <p>
 * CAMERA : CAMERA
 * <p>
 * CONTACTS : READ_CONTACTS WRITE_CONTACTS GET_ACCOUNTS
 * <p>
 * LOCATION : ACCESS_FINE_LOCATION ACCESS_COARSE_LOCATION
 * <p>
 * MICROPHONE : RECORD_AUDIO
 * <p>
 * PHONE : READ_PHONE_STATE CALL_PHONE READ_CALL_LOG WRITE_CALL_LOG ADD_VOICEMAIL USE_SIP PROCESS_OUTGOING_CALLS
 * <p>
 * SENSORS :  BODY_SENSORS
 * <p>
 * SMS :  SEND_SMS  RECEIVE_SMS READ_SMS RECEIVE_WAP_PUSH RECEIVE_MMS
 * <p>
 * STORAGE : READ_EXTERNAL_STORAGE WRITE_EXTERNAL_STORAGE
 */

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button activityBtn,contenrProBtn,writeFileBtn,menuBtn,uiBtn,broadCastBtn,serviceBtn,handlerBtn,forceOffLineBtn,dataBtn;
    //所需要申请的权限数组
    private static final String[] permissionsArray = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE,Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS,Manifest.permission.READ_SMS};
    //还需申请的权限列表
    private List<String> permissionsList = new ArrayList<String>();
    //申请权限后的返回码
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 100;

    private IntentFilter intentFilter;
    private ForceOfflineReceiver2 forceOfflineReceiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("activity","onCreate1");
        setContentView(R.layout.activity_main);
        initView();
        setTitle("知识点");
        checkRequiredPermission(this);
        setListener();
        intentFilter = new IntentFilter();
        intentFilter.addAction("top.jinyifei.forceOffLine");
        forceOfflineReceiver2=new ForceOfflineReceiver2();
        registerReceiver(forceOfflineReceiver2,intentFilter);
    }

    private void setListener() {
        activityBtn.setOnClickListener(this);
        contenrProBtn.setOnClickListener(this);
        menuBtn.setOnClickListener(this);
        uiBtn.setOnClickListener(this);
        serviceBtn.setOnClickListener(this);
        broadCastBtn.setOnClickListener(this);
        handlerBtn.setOnClickListener(this);
        writeFileBtn.setOnClickListener(this);
        forceOffLineBtn.setOnClickListener(this);
        dataBtn.setOnClickListener(this);
    }

    private void initView() {
        activityBtn=(Button)findViewById(R.id.button);
        contenrProBtn=(Button)findViewById(R.id.button2);
        writeFileBtn=(Button)findViewById(R.id.button3);
        menuBtn=(Button)findViewById(R.id.button4);
        uiBtn=(Button)findViewById(R.id.button6);
        serviceBtn=(Button)findViewById(R.id.button9);
        broadCastBtn=(Button)findViewById(R.id.button7);
        handlerBtn=(Button)findViewById(R.id.button10);
        writeFileBtn=(Button)findViewById(R.id.button3);
        forceOffLineBtn=(Button)findViewById(R.id.button8);
        dataBtn=(Button)findViewById(R.id.button11);
    }

//    private void methodRequiresTwoPermission() {
//        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
//    }

    private void writeFile() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return;
        }
        try {
            File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
            File file = new File(dir,"test.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("文件内容...");
            writer.flush();
            writer.close();
            Toast.makeText(this, "写文件成功:"+file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "写文件失败", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Intent intent=new Intent();
                intent.setAction("myActivityCeshi");
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2=new Intent();
                intent2.setAction("myProvider");
                intent2.addCategory("aaa");
                startActivity(intent2);
                break;
            case R.id.button3:
                writeFile();
                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this,MenuActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(MainActivity.this,BaseUi.class));
                break;
            case R.id.button7:
                startActivity(new Intent(MainActivity.this,BroadCastActivity.class));
                break;
            case R.id.button8:
  //              Intent intentOffLine = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                Intent intentOffLine=new Intent("top.jinyifei.forceOffLine");
                sendBroadcast(intentOffLine);
                break;
            case R.id.button9:
                startActivity(new Intent(MainActivity.this,ServiceActivity.class));
                break;
            case R.id.button10:
                startActivity(new Intent(MainActivity.this,HandlerActivity.class));
                break;
            case  R.id.button11:
                startActivity(new Intent(MainActivity.this,DataActivity.class));
                break;

        }

    }

    private void checkRequiredPermission(final Activity activity){
        for (String permission : permissionsArray) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission);
            }
        }

        if(!permissionsList.isEmpty()){
            ActivityCompat.requestPermissions(activity, permissionsList.toArray(new String[permissionsList.size()]), REQUEST_CODE_ASK_PERMISSIONS);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                for (int i=0; i<permissions.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(MainActivity.this, "权限申请成功"+permissions[i], Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "权限被拒绝： "+permissions[i], Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }



    class ForceOfflineReceiver2 extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, Intent intent) {
            final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            dialogBuilder.setTitle("Warning");
            dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
            dialogBuilder.setCancelable(false);
            dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent); // 重新启动LoginActivity }
                }
            });
            AlertDialog alertDialog = dialogBuilder.create();
            // 需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
            // Android 6里可能因为权限的修改，这个对话框不能运行系统提示的弹框，改为这普通的提示
            alertDialog.show();
        }
    }



    @Override
    protected void onStart(){
        super.onStart();
        Log.d("activity","onStart1");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("activity","onReStart1");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("activity","onResume1");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("activity","onPause1");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("activity","onStop1");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("activity","onDestroy1");
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                           int[] grantResults) {
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
//    }

}
