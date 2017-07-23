package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import top.jinyifei.hopes.R;

public class HopesProgressBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 设置特性以允许在应用程序的标题栏上显示进度条（条状）
        requestWindowFeature(Window.FEATURE_PROGRESS);
        // 设置特性以允许在应用程序的标题栏上显示进度条（圆圈状）
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        this.setContentView(R.layout.progressbar);

        setTitle("ProgressBar");

        // 在标题栏上显示进度条（条状）
        setProgressBarVisibility(true);
        // 在标题栏上显示进度条（圆圈状）
        setProgressBarIndeterminateVisibility(true);
        // 指定进度条的进度
        setProgress(50*100);
        setSecondaryProgress(75*100);
    }
}
