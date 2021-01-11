package com.example.arcanoid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.graphics.Canvas;
import android.graphics.Color;

public class Ball{

    float x,y, x_global, y_global,change; double speed;
    ImageView image;
    Bitmap bitmap;

    Ball(ImageView imageView,int x_g,int y_g){
        image = imageView;
        bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        speed = 0.1;
        x_global = x_g;
        y_global = y_g;
        x = 1;
        y = -1;
        Log.e("Move",Float.toString(x) +" "+ Float.toString(y));
    }

    void Change(){
        image.setX(image.getX() + x);
        image.setY(image.getY() + y);
        if(image.getX() + bitmap.getWidth() == x_global | image.getX() == 0) x *= -1;
        if(image.getY() + bitmap.getHeight() == y_global | image.getY() == 0) y *= -1;
    }
}