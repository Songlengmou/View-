package com.example.syp.drawshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by syp on 17-6-1.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
//        canvas.drawColor(Color.WHITE);//白色背景

        Paint p = new Paint();
        p.setColor(0xff00ff00);

        //1.绘制矩形
        canvas.save(); //保存
        canvas.translate(200, 200);
        canvas.rotate(45, 50, 50);//旋转   canvas.rotate(45);
        canvas.scale(2, 1);//缩放
        canvas.drawRect(0, 0, 100, 100, p);
        canvas.restore(); //绘图状态置为 保存值

        //2.绘制圆形
        Paint circlePaint = new Paint();
        canvas.save();
        circlePaint.setColor(0xffff0000);
        canvas.drawCircle(50, 50, 50, circlePaint);
        canvas.restore();

        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
