package top.jinyifei.hopes.activitys.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.jinyifei.hopes.R;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HopesImageButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.imagebutton);

        setTitle("ImageButton");
        ImageButton imageButton=(ImageButton)findViewById(R.id.imageButton);
        //设置图片按钮的背景
        imageButton.setBackgroundResource(R.drawable.icon);
        // setOnClickListener() - 响应图片按钮的鼠标单击事件
        imageButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textview = (TextView)findViewById(R.id.textview);
                textview.setText("图片按钮被单击了");
            }
        });
    }
}
