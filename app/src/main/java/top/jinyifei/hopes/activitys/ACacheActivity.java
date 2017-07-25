package top.jinyifei.hopes.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.activitys.cache.SaveBitmapActivity;
import top.jinyifei.hopes.activitys.cache.SaveDrawableActivity;
import top.jinyifei.hopes.activitys.cache.SaveJsonArrayActivity;
import top.jinyifei.hopes.activitys.cache.SaveJsonObjectActivity;
import top.jinyifei.hopes.activitys.cache.SaveMediaActivity;
import top.jinyifei.hopes.activitys.cache.SaveObjectActivity;
import top.jinyifei.hopes.activitys.cache.SaveStringActivity;

/**
 * Created by jinyifei on 17/7/23.
 * 缓存测试界面
 */

public class ACacheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acache);
    }
    public void string(View v) {
        startActivity(new Intent().setClass(this, SaveStringActivity.class));
    }

    public void jsonobject(View v) {
        startActivity(new Intent().setClass(this, SaveJsonObjectActivity.class));
    }

    public void jsonarray(View v) {
        startActivity(new Intent().setClass(this, SaveJsonArrayActivity.class));
    }

    public void bitmap(View v) {
        startActivity(new Intent().setClass(this, SaveBitmapActivity.class));
    }

    public void media(View v) {
        startActivity(new Intent().setClass(this, SaveMediaActivity.class));
    }

    public void drawable(View v) {
        startActivity(new Intent().setClass(this, SaveDrawableActivity.class));
    }

    public void object(View v) {
        startActivity(new Intent().setClass(this, SaveObjectActivity.class));
    }
}
