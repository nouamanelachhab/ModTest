package me.inventory.admin.augscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Step1 extends AppCompatActivity {
   private ImageView progressBar;
    private TextView textView;
    ConstraintLayout button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);
        getSupportActionBar().hide();
    }

    public static int getRandom(int from, int to) {
        if (from < to)
            return from + new Random().nextInt(Math.abs(to - from));
        return from - new Random().nextInt(Math.abs(to - from));
    }


    public void godisclamer(View aa){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://freeflixhqpro.com/disclaimer/"));
        startActivity(viewIntent);

    }
    @SuppressLint("ResourceAsColor")
    public void next (View aa) {

        textView = findViewById(R.id.textView7);
        progressBar = findViewById(R.id.progressBar);
        button3 = findViewById(R.id.button3);

        button3.setBackground(ContextCompat.getDrawable(this ,R.drawable.button2));

        textView.setText("");
        progressBar.setVisibility(View.VISIBLE);


        RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,.5f,RotateAnimation.RELATIVE_TO_SELF,.5f);
        rotateAnimation.setDuration(700);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        progressBar.setAnimation(rotateAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Step1.this,Step2.class);
                startActivity(homeIntent);
                finish();
            }
        },getRandom(1000,5000));
    }

}