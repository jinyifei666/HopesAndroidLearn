package top.jinyifei.hopes.activitys.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import top.jinyifei.hopes.R;

public class HopesEditText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.edittext);
        setTitle("EditText");

        EditText txt = (EditText) this.findViewById(R.id.editText);
        txt.setText("我可编辑哦(⊙o⊙)");
    }
}
