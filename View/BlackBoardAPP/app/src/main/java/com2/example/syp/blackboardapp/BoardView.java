package com2.example.syp.blackboardapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by syp on 17-6-6.
 * <p>
 * 画板实现方案1  (2在BoardDrawing中)
 * <p>
 * １，ACTION_DOWN 事件决定着接下来的一系列事件的传递方向。返回TRUE ，则该一系列操作事件将由当前View的onToucheEvent 处理。返回false 事件将继续传递。直至返回Activity. Activity接收到其分发出去的ACTION_DOWN返回值false，则不再分发接下来的MOVE UP 事件。
 * <p>
 * 2、dispatchTouchEvent 分两种情况：ACTION_DOWN 时return 和 ACTION_MOVE 、ACTION_UP return 。ACTION_DOWN：返回TRUE和该View 的onTouchEvent ACTION_DOWN返回true 是一样的即告诉activity 当前View可以处理接下来的事件流。 返回false 结束事件剩下的也不再传递。ACTION_MOVE 、ACTION_UP ：这种情况说明其子View中已经开始处理事件流，在这里return直接导致该部分事件流不再继续传递，对于没有return的还按照正常的流程传递。
 * <p>
 * 3、onInterceptTouchEvent 不论什么时候拦截，接下来的事件都将传递给当前的onTouchEvent处理接下来的事件流。
 */

public class BoardView extends SurfaceView implements View.OnTouchListener {
    private float startX, startY;
    private Paint paint = new Paint();

    public BoardView(Context context) {
        super(context);

        getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                resetBoard();
            }

            private void resetBoard() {
                Canvas canvas = getHolder().lockCanvas();
                canvas.drawColor(0xffffffff);
                getHolder().unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        setOnTouchListener(this);
    }

    /**
     * setOnTouchListener 单独使用的时候返回值需要为true，这样才能保证移动的时候能后获取相应的监
     * 听，而非一次监听（即每次只有一个按下的事件）
     * setOnTouchListener 和 setOnClickListener 同时使用时，onTouch 的返回值要设为 false，这样既可
     * 以保证按下移动抬起事件可以被监听，并且点击事件也会被监听。(既监听到了Touch 也能监听到 click 事件了，可以重获焦点)
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                System.out.println("Action down");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("Action move");

                drawLineToPoint(event.getX(), event.getY());
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("Action up");
                break;
        }
        return true;
    }

    private void drawLineToPoint(float x, float y) {
        Canvas canvas = getHolder().lockCanvas();

        if (canvas != null) {
            canvas.drawLine(startX, startY, x, y, paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }
}
