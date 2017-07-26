package top.jinyifei.hopes.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import top.jinyifei.hopes.R;

/**
 * Created by jinyifei on 17/7/24.
 * 欢迎界面
 */

public class WelcomeActivity extends Activity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.activity_welcome);
        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    Intent intent = new Intent();
                    intent.setClass(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        new Thread(mRunnable).start();
    }

    private Runnable mRunnable = new Runnable() {
        public void run() {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mHandler.sendEmptyMessage(1);
        }
    };
}
