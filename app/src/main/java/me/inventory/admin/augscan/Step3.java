package me.inventory.admin.augscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class Step3 extends AppCompatActivity {
    private ImageView progressBar;
    private TextView textView;
    TextInputEditText input1;
    TextInputEditText input2;
    ConstraintLayout button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);
        getSupportActionBar().hide();
    }

    public void godisclamer(View aa){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://freeflixhqpro.com/disclaimer/"));
        startActivity(viewIntent);

    }

    public static int getRandom(int from, int to) {
        if (from < to)
            return from + new Random().nextInt(Math.abs(to - from));
        return from - new Random().nextInt(Math.abs(to - from));
    }

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
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!input1.getText().toString().matches("")) {
                    if (input1.getText().toString().equals(input2.getText().toString())) {
                        Intent homeIntent = new Intent(Step3.this, Loading.class);
                        startActivity(homeIntent);
                        finish();
                    }

                    else {
                        input1.setError("Password Mismatch");
                        input2.setError("Password Mismatch");
                        textView.setText("CONTINUE");
                        progressBar.setVisibility(View.GONE);
                        progressBar.clearAnimation();

                    }
                }
                else {
                    input1.setError("Enter a Password");
                    textView.setText("CONTINUE");
                    progressBar.setVisibility(View.GONE);
                    progressBar.clearAnimation();

                }


            }
        },getRandom(500,3000));
    }
}