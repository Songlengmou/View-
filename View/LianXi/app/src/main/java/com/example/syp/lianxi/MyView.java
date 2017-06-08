package com.example.syp.lianxi;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by syp on 17-6-1.
 * <p>
 * 绘制奥运五环
 */

public class MyView extends SurfaceView implements SurfaceHolder.Callback {
    public MyView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();//①
        canvas.drawColor(Color.WHITE);

        //1.绘制圆形
        Paint paint = new Paint();
        canvas.save();
        paint.setAntiAlias(true);        //使用抗锯齿功能
        paint.setStrokeWidth(6);        //设置笔触的宽度

        paint.setColor(Color.BLUE);
        canvas.drawCircle(280, 70, 50, paint);    //绘制蓝色的圆形

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(330, 70, 50, paint);    //绘制黄色的圆形

        paint.setColor(Color.BLACK);
        canvas.drawCircle(380, 70, 50, paint);    //绘制黑色的圆形

        paint.setColor(Color.GREEN);
        canvas.drawCircle(305, 110, 50, paint);    //绘制绿色的圆形

        paint.setColor(Color.RED);
        canvas.drawCircle(346, 110, 50, paint);    //绘制红色的圆形

        paint.setColor(0xff2355ff);
        paint.setTextSize(40f);
        canvas.drawText("北京欢迎你", 240, 200, paint);
        canvas.restore();

        //2.绘制图片
        canvas.save();
        BitmapDrawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = (BitmapDrawable) getContext().getDrawable(R.drawable.zqg);
        } else {
            drawable = (BitmapDrawable) getContext().getResources().getDrawable(R.drawable.zqg);
        }
        canvas.drawBitmap(drawable.getBitmap(), 245, 300, null);
        canvas.restore();

        holder.unlockCanvasAndPost(canvas);//②
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
