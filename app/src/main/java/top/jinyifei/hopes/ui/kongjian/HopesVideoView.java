package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.jinyifei.hopes.R;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

public class HopesVideoView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview);

        setTitle("VideoView");
        VideoView videoView=(VideoView)findViewById(R.id.videoView);
        // 指定需要播放的视频的地址
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.mv));
        //videoView.setVideoPath();绝对路径放入网络视频链接也可以

        // 设置播放器的控制条
        videoView.setMediaController(new MediaController(this));
        // 开始播放视频
        videoView.start();
    }
}
