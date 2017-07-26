package top.jinyifei.hopes.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import top.jinyifei.hopes.R;

/**
 * author: jinyifei
 * time:  Created on 2017/7/25 13:12
 * email：jyf@whu.edu.cn
 * function：activity生命周期测试
 */

public class ActivityActivity extends AppCompatActivity {

    private Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("activity","onCreate2");
        setContentView(R.layout.activity_activity);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityActivity.this,ReturnDataActivity.class);
                startActivityForResult(intent,2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("activity","onStart2");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("activity","onReStart2");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("activity","onResume2");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("activity","onPause2");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("activity","onStop2");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("activity","onDestroy2");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 2:
                if (resultCode==RESULT_OK){
                    Log.d("data",data.getStringExtra("data_return"));
                }
                break;
        }
    }


}
