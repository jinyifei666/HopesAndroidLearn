package top.jinyifei.hopes.activitys.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import top.jinyifei.hopes.R;

public class HopesCheckBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.checkbox);

        setTitle("CheckBox");

        CheckBox chk=(CheckBox)this.findViewById(R.id.chk1);
        // setOnCheckedChangeListener() - 响应复选框的选中状态改变事件
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                TextView text = (TextView)findViewById(R.id.textview1);
                text.setText("CheckBox01 的选中状态：" + String.valueOf(isChecked));
            }
        });
    }
}
