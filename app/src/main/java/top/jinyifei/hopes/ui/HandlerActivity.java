package top.jinyifei.hopes.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import top.jinyifei.hopes.R;

public class HandlerActivity extends AppCompatActivity {

    private static final int MSG_SUCCESS = 0;
    private static final int MSG_FAILURE = 1;

    private ImageView img;
    private Button okButton;
    private Thread myThread;
    private Handler myhanHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SUCCESS:
                    //img.setImageBitmap((Bitmap) msg.obj);
                    Toast.makeText(getApplicationContext(), "获取成功",
                            Toast.LENGTH_LONG).show();
                    break;

                case MSG_FAILURE:
                    Toast.makeText(getApplicationContext(), "获取失败",
                            Toast.LENGTH_LONG).show();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        img = (ImageView) findViewById(R.id.imageView);
        okButton = (Button) findViewById(R.id.button);
        okButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (myThread == null) {
                    myThread = new Thread(runnable);
                    myThread.start();
                } else {
                    myThread = new Thread(runnable);
                    myThread.start();
                }

            }
        });
    }


    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            int i=(int) (Math.random() * 2);
            Log.w("ceshi",String.valueOf(i));
            if (i==1){
                myhanHandler.obtainMessage(MSG_FAILURE).sendToTarget();
            }else {
                myhanHandler.obtainMessage(MSG_SUCCESS, new Object()).sendToTarget();
            }
        }
    };
}
