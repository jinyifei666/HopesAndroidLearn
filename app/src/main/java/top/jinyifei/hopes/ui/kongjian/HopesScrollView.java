package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import top.jinyifei.hopes.R;

public class HopesScrollView extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.scrollview);

        setTitle("ScrollView");

        TextView textView = (TextView)this.findViewById(R.id.textview5);
        textView.setText("a\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na");



    }
}
