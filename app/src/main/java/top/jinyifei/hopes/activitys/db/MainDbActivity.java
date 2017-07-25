package top.jinyifei.hopes.activitys.db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.jinyifei.hopes.R;

public class MainDbActivity extends AppCompatActivity implements View.OnClickListener{


    private Button addClassBtn;
    private Button addStuBtn;
    private Button queryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_db);
        addClassBtn = (Button)findViewById(R.id.add_class);
        addStuBtn = (Button)findViewById(R.id.add_student);
        queryBtn = (Button)findViewById(R.id.query_btn);

        addClassBtn.setOnClickListener(this);
        addStuBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_class:
                startActivity(new Intent(MainDbActivity.this,AddClassActivity.class));
                break;

            case R.id.add_student:
                startActivity(new Intent(MainDbActivity.this,AddStuActivity.class));
                break;

            case R.id.query_btn:
                startActivity(new Intent(MainDbActivity.this,QueryActivity.class));
                break;
        }
    }
}
