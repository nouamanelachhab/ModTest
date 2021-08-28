package me.inventory.admin.augscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.currentThread;

public class Loading extends AppCompatActivity {
    private int counter;
    private int time;
    private ImageView progressBar;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        getSupportActionBar().hide();

        RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,.5f,RotateAnimation.RELATIVE_TO_SELF,.5f);
        rotateAnimation.setDuration(700);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        progressBar = findViewById(R.id.progressBar);
        image = findViewById(R.id.imageView6);
        image.setVisibility(View.VISIBLE);
        progressBar.setAnimation(rotateAnimation);
        CharSequence[] txt = {"Account Processing.","Account Processing..","Account Processing...","Saving Informations.","Saving Informations..","Saving Informations...","Connecting To Server.","Connecting To Server..","Connecting To Server..."};

        Thread counterThread;
        Thread counterThread2;
        Thread counterThread3;





        Timer timer = new Timer();



        int a = getRandom(3000,8000);
        int b = getRandom(7000,10000);
        int c = getRandom(5000,9000);

        counter = 0;

        // first thread
        counterThread=new Thread(()->{
            try{
                image.setBackground(ContextCompat.getDrawable(this ,R.drawable.account));
                while(true){
                    if(counter == 0)
                    {
                        setText(txt[0]);
                        counter+=1;
                    }
                    else if(counter == 1)
                    {
                        setText(txt[1]);
                        counter+=1;
                    }
                    else if(counter == 2)
                    {
                        setText(txt[2]);
                        counter=0;
                    }


                    Thread.sleep(1000);
                }


            }
            catch (Exception e){

            }
        });

        counterThread2=new Thread(()->{
            try{
                image.setBackground(ContextCompat.getDrawable(this ,R.drawable.saving));
                while(true){
                    if(counter == 0)
                    {
                        setText(txt[3]);
                        counter+=1;
                    }
                    else if(counter == 1)
                    {
                        setText(txt[4]);
                        counter+=1;
                    }
                    else if(counter == 2)
                    {
                        setText(txt[5]);
                        counter=0;
                    }


                    Thread.sleep(1000);
                }


            }
            catch (Exception e){

            }
        });


        counterThread3=new Thread(()->{
            try{
                image.setBackground(ContextCompat.getDrawable(this ,R.drawable.server));
                while(true){
                    if(counter == 0)
                    {
                        setText(txt[6]);
                        counter+=1;
                    }
                    else if(counter == 1)
                    {
                        setText(txt[7]);
                        counter+=1;
                    }
                    else if(counter == 2)
                    {
                        setText(txt[8]);
                        counter=0;
                    }


                    Thread.sleep(1000);
                }


            }
            catch (Exception e){

            }
        });






        counterThread.start();






        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                counterThread.interrupt();
                counter =0;

                counterThread2.start();

            }
        },a);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                counterThread2.interrupt();
                counter =0;
                counterThread3.start();

            }
        },a+b);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                counterThread3.interrupt();
                Intent homeIntent = new Intent(Loading.this,Home.class);
                startActivity(homeIntent);
                finish();

            }
        },a+b+c);




    }

    private void setText(final CharSequence text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((TextView) findViewById(R.id.loading_text)).setText(text);
            }
        });
    }

    public static int getRandom(int from, int to) {
        if (from < to)
            return from + new Random().nextInt(Math.abs(to - from));
        return from - new Random().nextInt(Math.abs(to - from));
    }


}