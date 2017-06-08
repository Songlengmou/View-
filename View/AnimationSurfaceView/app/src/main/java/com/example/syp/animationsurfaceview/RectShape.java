package com.example.syp.animationsurfaceview;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by syp on 17-6-1.
 * <p>
 * 基于绘图API的动画实现(做动画)
 */

public class RectShape {

    private Paint paint = new Paint();
    private float x = 0, y = 0, width = 100, height = 100;
    private float speedX = 3;

    RectShape() {
        paint.setColor(0xff0000ff);
    }

    void draw(Canvas canvas) {
        canvas.drawRect(x, y, x + width, y + height, paint);
        x += speedX;
        if (x > 200) {
            speedX = -Math.abs(speedX);
        }
        if (x < 0) {
            speedX = Math.abs(speedX);
        }

    }

    //---------------------------------------------------
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
