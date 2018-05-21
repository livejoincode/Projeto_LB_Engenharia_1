package view;
import com.joincode.uepb.myapplication.R;
import controller.LanchoneteController;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashHome extends AppCompatActivity {

    private final static int TIME_SPLASH = 2000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_home);
            ImageView imv = findViewById(R.id.imvlogo);
            Animation homeSplash = AnimationUtils.loadAnimation(this,R.anim.splash);
            imv.startAnimation(homeSplash);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }, TIME_SPLASH);
        }


}
