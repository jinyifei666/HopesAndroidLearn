package top.jinyifei.hopes.activitys.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import top.jinyifei.hopes.R;

public class HopesImageView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.imageview);

        setTitle("ImageView");

        ImageView imgView = (ImageView) this.findViewById(R.id.imageView);
        imgView.setBackgroundResource(R.drawable.icon1);
    }
}
