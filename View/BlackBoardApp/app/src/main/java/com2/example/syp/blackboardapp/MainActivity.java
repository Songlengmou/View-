package com2.example.syp.blackboardapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private Button btn_reset;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myView = new MyView(this);
        setContentView(myView);


//        setContentView(R.layout.activity_main);

//        myView = (MyView) findViewById(R.id.SurfaceView);
//
//        btn_reset = (Button) findViewById(R.id.btn_reset);
//        btn_reset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myView.reset();
//            }
//        });
    }

//    //保存
//    public void save() {
//        try {
//            File file = new File(Environment.getExternalStorageDirectory(),
//                    System.currentTimeMillis() + ".jpg");
//            OutputStream stream = new FileOutputStream(file);
////            baseBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            stream.close();
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
//            intent.setData(Uri.fromFile(Environment
//                    .getExternalStorageDirectory()));
//            sendBroadcast(intent);
//            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//        }
//    }
}
