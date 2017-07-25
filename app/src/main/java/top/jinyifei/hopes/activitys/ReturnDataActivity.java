package top.jinyifei.hopes.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.jinyifei.hopes.R;

public class ReturnDataActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_data);
        Button button2 = (Button) findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在活动销毁时返回结果给上一个活动
                // setResult()方法专门用于向上一个活动返回数据，
                // 它接收两个参数，第一个参数用于向上一个活动返回处理结果，
                // 一般只使用RESULT_OK或RESULT_CANCELED这两个值，
                // 第二个参数则是把带有数据的Intent传递回去。
                Intent intent = new Intent();
//                intent.putExtra("data_return", "Hello FirstActivity");
//                setResult(RESULT_OK, intent);
//                finish();

                intent.putExtra("data_return","hello");
                setResult(RESULT_OK,intent);
                finish();
                // 测试FirstActivity的singleTop/singleTask启动模式
                // Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                // startActivity(intent);

                // 测试SecondActivity的singleInstance启动模式
//                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity(Back Button)");
        setResult(RESULT_OK, intent);
        finish();
    }
}
