package top.jinyifei.hopes.activitys.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import top.jinyifei.hopes.R;

public class HopesTextSwitcher extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.textswitcher);

        setTitle("TextSwithcer");

        final TextSwitcher switcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        // 指定转换器的 ViewSwitcher.ViewFactory
        switcher.setFactory(this);

        // 设置淡入和淡出的动画效果
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);

        // 单击一次按钮改变一次文字
        Button btnChange = (Button) this.findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switcher.setText(String.valueOf(new Random().nextInt()));
            }
        });
    }
    // 重写 ViewSwitcher.ViewFactory 的 makeView()，返回一个 View
    @Override
    public View makeView() {
        TextView textView = new TextView(this);
        textView.setTextSize(36);
        return textView;
    }
}
