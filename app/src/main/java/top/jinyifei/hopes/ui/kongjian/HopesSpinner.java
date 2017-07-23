package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import top.jinyifei.hopes.R;

public class HopesSpinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        setTitle("HopesSpinner");

        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        // 设置下拉框控件的标题文本
        spinner.setPrompt("请选择");
        // 实例化适配器，指定显示格式及数据源
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.colors,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // setOnItemSelectedListener() - 响应下拉框的选中值发生变化的事件

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                TextView textview4 = (TextView)findViewById(R.id.textview4);
                textview4.setText(((TextView)arg1).getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}
