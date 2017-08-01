package top.jinyifei.hopes.activitys;

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
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.adapter.MyFragmentPagerAdapter;
import top.jinyifei.hopes.activitys.viewPagerFragment.ViewPagerFragmentActivity;


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

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener{

    //所需要申请的权限数组
    private static final String[] permissionsArray = new String[]{Manifest.permission.READ_PHONE_STATE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE,Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS,Manifest.permission.READ_SMS};
    //还需申请的权限列表
    private List<String> permissionsList = new ArrayList<String>();
    //申请权限后的返回码
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 100;

    private IntentFilter intentFilter;
    private ForceOfflineReceiver2 forceOfflineReceiver2;

    //UI Objects
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("activity","onCreate1");
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_channel.setChecked(true);
        setTitle("主界面");
        checkRequiredPermission(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("top.jinyifei.forceOffLine");
        forceOfflineReceiver2=new ForceOfflineReceiver2();
        registerReceiver(forceOfflineReceiver2,intentFilter);
    }

    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_channel = (RadioButton) findViewById(R.id.rb_channel);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_better = (RadioButton) findViewById(R.id.rb_better);
        rb_setting = (RadioButton) findViewById(R.id.rb_setting);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
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
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_channel:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_message:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_better:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_setting:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_channel.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_message.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_better.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_setting.setChecked(true);
                    break;
            }
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
        unregisterReceiver(forceOfflineReceiver2);
    }

}
