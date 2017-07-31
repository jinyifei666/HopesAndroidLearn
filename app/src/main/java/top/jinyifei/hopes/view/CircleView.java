package top.jinyifei.hopes.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author: jinyifei
 * time:  Created on 2017/7/28.
 * email：jyf@whu.edu.cn
 * function：
 */

public class CircleView extends View {
    Paint paint;
    Path path;
    private float[] array;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        initPath();
        array=new float[]{0,100,200,300,400,500,600,700};

    }

    private void initPath() {
        path=new Path();
        path.moveTo(200,200);
        path.lineTo(200,1000);
        path.lineTo(1000,1000);
    }

    private void initPaint() {
        paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
        for (int i=0;i<8;i++){
            canvas.drawLine(200,1000-i*100,220,1000-i*100,paint);
            paint.setStrokeWidth(2);
            canvas.drawText(String.valueOf(array[i]),150,1000-i*100,paint);
        }
    }

}
