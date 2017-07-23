package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import top.jinyifei.hopes.R;

public class HopesMultiAutoCompleteTextView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiautocompletetextview);

        setTitle("MultiAutoCompleteTextView");
        // 实例化适配器，指定显示格式及数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                ary);
        MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView) findViewById(R.id.editText1);
        textView.setAdapter(adapter);

        // 设置多个值之间的分隔符，此处为逗号
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    // 自动完成控件的所需数据的数据源
    private String[] ary = new String[] {
            "abc",
            "abcd",
            "abcde",
            "abcdef",
            "abcdefg",
            "hij",
            "hijk",
            "hijkl",
            "hijklm",
            "hijklmn",
    };
}
