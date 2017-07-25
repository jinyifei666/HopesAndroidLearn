package top.jinyifei.hopes.activitys.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.ZoomControls;

import top.jinyifei.hopes.R;


public class HopesZoomControls extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.zoomcontrols);

        setTitle("ZoomControls");

        ZoomControls zoomControls=(ZoomControls)findViewById(R.id.zoomControls);
        //setOnZoomInClickListener() - 响应单击放大按钮的事件
        zoomControls.setOnZoomInClickListener(new OnClickListener(){
            public void onClick(View v){
                Toast.makeText(HopesZoomControls.this, "单击了放大按钮", Toast.LENGTH_SHORT).show();
            }
        });
        // setOnZoomOutClickListener() - 响应单击缩小按钮的事件
        zoomControls.setOnZoomOutClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HopesZoomControls.this, "单击了缩小按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
