package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.jinyifei.hopes.R;

public class HopesTimePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.timepicker);
        // 具体的应用可参见对话框中的示例
        setTitle("TimePicker");
    }
}
