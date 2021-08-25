package me.inventory.admin.augscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

public class MainActivity extends AppCompatActivity {
    LazyLoader containerLL;
    ImageView imv;

    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        animatelogo();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this,FirstSlides.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }
    private void animatelogo(){
        Animation fadeInAnimation =  AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadeInAnimation.setDuration(1000);
        imv = findViewById(R.id.imageView);
        imv.startAnimation(fadeInAnimation);

    }
}