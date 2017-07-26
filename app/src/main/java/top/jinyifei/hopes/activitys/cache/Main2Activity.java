package top.jinyifei.hopes.activitys.cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.utils.ACache;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ACache aCache=ACache.get(Main2Activity.this);
        aCache.put("ceshi","hello");
        aCache.getAsString("ceshi");
    }
}
