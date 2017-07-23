package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import top.jinyifei.hopes.R;

public class HopesToggleButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.togglebutton);

        setTitle("ToggleButton");

        final ToggleButton btn = (ToggleButton) findViewById(R.id.togglebutton);
        // setOnClickListener() - 响应按钮的鼠标单击事件
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = (TextView) findViewById(R.id.textview2);
                // ToggleButton.isChecked() - 双状态按钮的按钮状态
                txt.setText("按钮状态：" + String.valueOf(btn.isChecked()));
            }
        });
    }
}
