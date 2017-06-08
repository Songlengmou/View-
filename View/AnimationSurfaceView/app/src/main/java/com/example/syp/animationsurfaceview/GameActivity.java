package com.example.syp.animationsurfaceview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by syp on 17-6-1.
 * <p>
 * 基于绘图API的动画实现(做动画)
 */

public class GameActivity extends Activity {

    private GameView gameView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);
    }
}
