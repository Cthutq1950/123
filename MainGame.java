package com.example.arcanoid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainGame extends FragmentActivity
        implements View.OnTouchListener {

    Bitmap bitmap;
    int width, heidth;
    int [] arr = new int[2];
    boolean pause_ball = true;
    ImageView ball,platform;
    MainGameThread mainGameThread;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        Display display = getWindowManager().getDefaultDisplay();

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.platform);
        relativeLayout = findViewById(R.id.Rlayout);
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        heidth = size.y;

        platform = findViewById(R.id.platform);


        ball = findViewById(R.id.Ball);
        mainGameThread = new MainGameThread(false, ball, width,heidth);
        platform.setOnTouchListener(this);
        ball.getLocationOnScreen(arr);
        final ImageButton button = findViewById(R.id.start);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGameThread.Game = true;
                mainGameThread.start();
                button.setVisibility(View.GONE);
                button.setEnabled(false);
                pause_ball = false;
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int X;
        int Y;
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE: {
                    X = (int) event.getRawX();
                    Y = (int) event.getRawY();
                    Log.e("Move", Integer.toString(X) + " " + Integer.toString(Y));
                    if (X + bitmap.getWidth() < relativeLayout.getWidth()) {
                        view.setX(X);
                        if (pause_ball) {
                            ball.setX(X + bitmap.getWidth() / 2);
                        }
                    }
                    break;
                }

            }
            return true;
        }


}