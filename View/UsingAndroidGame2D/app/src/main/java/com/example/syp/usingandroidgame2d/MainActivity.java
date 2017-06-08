package com.example.syp.usingandroidgame2d;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.yunp.androidgame2d.display.Container;
import top.yunp.androidgame2d.display.GameView;
import top.yunp.androidgame2d.display.Image;
import top.yunp.androidgame2d.display.Shape;
import top.yunp.androidgame2d.display.TextLine;
import top.yunp.androidgame2d.events.TouchEvent;
import top.yunp.androidgame2d.tools.BitmapLoader;
import top.yunp.androidgame2d.tween.ScaleTween;
import top.yunp.lib.java.event.EventListener;

public class MainActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);
        gameView.setFps(50);

        final Image image = new Image(BitmapLoader.loadBitmap(this, R.mipmap.ic_launcher));
        gameView.add(image);
        image.setWidth(300);
        image.setHeight(300);
        image.setRegX(150);//注册点
        image.setX(150);

        final ScaleTween st = new ScaleTween(null, 0, 1, 1, 1);
        st.setFrames(100); //(速度)  帧

        image.touchDown.add(new EventListener<TouchEvent>() {
            @Override
            public boolean onReceive(TouchEvent event, Object target) {
                st.setTarget(image);
                st.start();
                return false;
            }
        });

//-----------------制作小卡片(与上述无关)------------------------------------------------
        Container card = new Container();
        Shape rect = new Shape();
        rect.getPaint().setColor(Color.BLUE);
        rect.getPath().addRect(0, 0, 100, 100, Path.Direction.CW);
        card.add(rect);

        TextLine t1 = new TextLine("1");
        t1.getPaint().setColor(Color.WHITE);
        t1.setY(80);
        t1.setSize(80);
        card.add(t1);

        card.setX(400);
        card.setY(200);
        gameView.add(card);
    }
}
