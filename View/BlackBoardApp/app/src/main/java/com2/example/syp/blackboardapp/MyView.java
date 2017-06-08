package com2.example.syp.blackboardapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by syp on 17-6-6.
 */

public class MyView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {
    private Paint p = new Paint();
    private Path path = new Path();

    public MyView(Context context) {
        super(context);

        getHolder().addCallback(this);
        p.setColor(Color.RED);
        p.setTextSize(10);
        p.setStrokeWidth(5);
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.STROKE);
        setOnTouchListener(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    /**
     * setOnTouchListener 单独使用的时候返回值需要为true，这样才能保证移动的时候能后获取相应的监
     * 听，而非一次监听（即每次只有一个按下的事件）
     * setOnTouchListener 和 setOnClickListener 同时使用时，onTouch 的返回值要设为 false，这样既可
     * 以保证按下移动抬起事件可以被监听，并且点击事件也会被监听。(既监听到了Touch 也能监听到 click 事件了，可以重获焦点)
     */
    //手势的操作
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //moveTo()方法可把窗口的左上角移动到一个指定的坐标
                path.moveTo(event.getX(), event.getY());
                draw();
                break;
            case MotionEvent.ACTION_MOVE:
                //用当前画笔画一条线，从当前位置连到一个指定的点
                path.lineTo(event.getX(), event.getY());
                draw();
                break;
        }
        return true;
    }

    //画布的设置
    private void draw() {
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.GRAY);//画板背景色
        canvas.drawPath(path, p);
        getHolder().unlockCanvasAndPost(canvas);
    }

    //重置
    public void reset() {
        path.reset();
        draw();
    }


}
