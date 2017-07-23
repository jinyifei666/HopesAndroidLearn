package top.jinyifei.hopes.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.jinyifei.hopes.R;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sqlBtn,fileBtn,contenProBtn,shareBtn;

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
        shareBtn.setOnClickListener(this);
        fileBtn.setOnClickListener(this);
        contenProBtn.setOnClickListener(this);
        sqlBtn.setOnClickListener(this);
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



        }
    }
}
