package top.jinyifei.hopes.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.models.ChartEntity;
import top.jinyifei.hopes.view.BallMoveView;
import top.jinyifei.hopes.view.LineChart;

public class MyViewActivity extends AppCompatActivity {
    BallMoveView ballview;
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        ballview=(BallMoveView)findViewById(R.id.ballmove);
        lineChart = (LineChart) findViewById(R.id.chart);
        List<ChartEntity> data = new ArrayList<>();
        for(int i =0;i<20;i++){
            data.add(new ChartEntity(String.valueOf(i), (float) (Math.random()*1000)));
        }
        lineChart.setData(data);
        new Timer().schedule(new TimerTask()	{
            @Override
            public	void run()	{
                ballview.postInvalidate();
            }
        },200,50);
    }
}
