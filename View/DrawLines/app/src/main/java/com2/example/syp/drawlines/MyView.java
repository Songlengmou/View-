package com2.example.syp.drawlines;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by syp on 17-6-6.
 */

public class MyView extends SurfaceView implements SurfaceHolder.Callback {
    public MyView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);//背景色

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
//      paint.setStrokeJoin(Paint.Join.BEVEL);//样式
        paint.setStrokeCap(Paint.Cap.ROUND);


        //绘制线条
//      canvas.drawLine(100, 100, 200, 100, paint); ①
        canvas.drawLines(new float[]{
                100, 100, 200, 100, 200, 200, 200, 300
        }, paint);  //②

        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
