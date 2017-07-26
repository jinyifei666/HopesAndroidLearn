package top.jinyifei.hopes.activitys;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.activitys.fragment.AnotherRightFragment;

public class StaticFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnotherRightFragment fragment = new AnotherRightFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();   // 开启一个事务，通过调用beginTransaction()方法开启
                transaction.hide(fragmentManager.findFragmentById(R.id.left_fragment));
                transaction.add(R.id.layout_left, fragment);
            //    transaction.addToBackStack(null);   // 接收一个名字用于述返回栈的状态
                transaction.commit();   // 提交事
            }
        });
    }
}
