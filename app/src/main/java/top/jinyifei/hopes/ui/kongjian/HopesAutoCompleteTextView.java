package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import top.jinyifei.hopes.R;

public class HopesAutoCompleteTextView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocompletetextview);

        setTitle("AutoCompleteTextView");
        // 实例化适配器，指定显示格式及数据源
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                ary);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.editText);
        // 指定自动完成控件的适配器
        textView.setAdapter(adapter);
    }

    private String[]ary=new String[]{
            "abc",
            "abcd",
            "abcde",
            "abcdef",
            "hij",
            "hijk",
            "hijkl",
            "hijklm",
            "hijklmn",
    };
}
