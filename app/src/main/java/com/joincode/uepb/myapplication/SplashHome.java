package com.joincode.uepb.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

public class SplashHome extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private TextView txv;
    private ImageView imv;
    Intent intet;
    Handler  handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slapsher();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_home);
        imv = (ImageView)findViewById(R.id.imvlogo);
        Animation homeSplash = AnimationUtils.loadAnimation(this,R.anim.splash);
        imv.startAnimation(homeSplash);
        //intet = new Intent(SplashHome.this, MainActivity.class);
        handler.postDelayed(runnable,2000);


    }
    protected void slapsher(){
        startActivity(intet);
       // finish();
    }

}
