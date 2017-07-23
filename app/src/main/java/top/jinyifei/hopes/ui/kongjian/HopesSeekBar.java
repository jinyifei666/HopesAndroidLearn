package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import top.jinyifei.hopes.R;

public class HopesSeekBar extends AppCompatActivity implements
	SeekBar.OnSeekBarChangeListener {

        SeekBar mSeekBar;
        TextView mProgressText;
        TextView mTrackingText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.seekbar);

            setTitle("SeekBar");

            SeekBar mSeekBar = (SeekBar) findViewById(R.id.seekbar);
            // setOnSeekBarChangeListener() - 响应拖动进度条事件
            mSeekBar.setOnSeekBarChangeListener(this);

            mProgressText = (TextView) findViewById(R.id.progress1);
            mTrackingText = (TextView) findViewById(R.id.tracking);
        }
        // 拖动进度条后，进度发生改变时的回调事件
    public void onProgressChanged(SeekBar seekBar,int progress,
                                  boolean fromTouch){
        mProgressText.setText(progress+"%");
    }
    // 拖动进度条前开始跟踪触摸
    public void onStartTrackingTouch(SeekBar seekBar) {
        mTrackingText.setText("开始跟踪触摸");
    }

    // 拖动进度条后停止跟踪触摸
    public void onStopTrackingTouch(SeekBar seekBar) {
        mTrackingText.setText("停止跟踪触摸");
    }
}
