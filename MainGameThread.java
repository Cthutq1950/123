package com.example.arcanoid;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.widget.ImageView;

public class MainGameThread extends  Thread {
    boolean Game;
    Ball ball;

    MainGameThread(boolean start, ImageView imageView, int a, int b) {
        Game = start;
        ball = new Ball(imageView, a,b);
    }

    public void run() {
        while (Game) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ball.Change();
        }
    }
}

