package top.jinyifei.hopes.activitys.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import top.jinyifei.hopes.R;

public class HopesRatingBar extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    private RatingBar mRatingBar;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ratingbar);
        setTitle("RatingBar");

        mTextView = (TextView) findViewById(R.id.textview3);
        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);

        // setOnRatingBarChangeListener() - 响应评分值发生改变的事件
        mRatingBar.setOnRatingBarChangeListener(this);
    }
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating,
                                boolean fromUser) {
        mTextView.setText(String.valueOf(rating));
    }

}
