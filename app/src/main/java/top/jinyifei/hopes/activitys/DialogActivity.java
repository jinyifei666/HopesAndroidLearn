package top.jinyifei.hopes.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import top.jinyifei.hopes.R;

/**
 * author: jinyifei
 * time:  Created on 2017/7/25 13:25
 * email：jyf@whu.edu.cn
 * function：测试生命周期onPause建立的一个透明的activity
 */
public class DialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);
    }
}
