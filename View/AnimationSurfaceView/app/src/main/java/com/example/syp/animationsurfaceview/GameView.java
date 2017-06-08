package com.example.syp.animationsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by syp on 17-6-1.
 * <p>
 * 基于绘图API的动画实现(做动画)
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private Timer timer = new Timer();
    private boolean running = false;
    private int currentWidth = 800;
    private int currentHeight = 480;
    private RectShape rectShape = new RectShape();

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startTimer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        currentWidth = width;
        currentHeight = height;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopTimer();
    }

    private void draw() {
        Canvas canvas = getHolder().lockCanvas();
        if (canvas != null) {
            canvas.drawColor(0xffffffff);
            rectShape.draw(canvas);


            getHolder().unlockCanvasAndPost(canvas);
        }
//        System.out.println(">>>>>>>>>>>");
    }

    private void startTimer() {
        if (!running) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    draw();
                }
            }, 20, 20);
            running = true;
        }
    }

    private void stopTimer() {
        if (running) {
            timer.cancel();//结束所有计时
            running = false;
        }
    }
}
