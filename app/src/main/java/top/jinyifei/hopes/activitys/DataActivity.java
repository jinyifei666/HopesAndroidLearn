package top.jinyifei.hopes.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.activitys.db.MainDbActivity;

/**
 * author: jinyifei
 * time:  Created on 2017/7/25 13:25
 * email：jyf@whu.edu.cn
 * function：数据存储测试
 */

public class DataActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sqlBtn,fileBtn,contenProBtn,shareBtn,acacheBtn,dbBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        initView();
    }

    public void initView(){
        sqlBtn=(Button)findViewById(R.id.sqlite);
        fileBtn=(Button)findViewById(R.id.file);
        contenProBtn=(Button)findViewById(R.id.contenprovider);
        shareBtn=(Button)findViewById(R.id.shareprefecence);
        acacheBtn=(Button)findViewById(R.id.acacheBtn);
        dbBtn=(Button)findViewById(R.id.dbBtn);

        shareBtn.setOnClickListener(this);
        fileBtn.setOnClickListener(this);
        contenProBtn.setOnClickListener(this);
        sqlBtn.setOnClickListener(this);
        acacheBtn.setOnClickListener(this);
        dbBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sqlite:
                startActivity(new Intent(DataActivity.this,SqliteActivity.class));
                break;
            case R.id.shareprefecence:
                startActivity(new Intent(DataActivity.this,SharePreferencesActivity.class));
                break;
            case R.id.contenprovider:
                startActivity(new Intent(DataActivity.this,ContentProviderActivity.class));
                break;
            case R.id.file:
                startActivity(new Intent(DataActivity.this,FileActivity.class));
                break;
            case R.id.acacheBtn:
                startActivity(new Intent(DataActivity.this,ACacheActivity.class));
                break;
            case R.id.dbBtn:
                startActivity(new Intent(DataActivity.this,MainDbActivity.class));
                break;
        }
    }
}
