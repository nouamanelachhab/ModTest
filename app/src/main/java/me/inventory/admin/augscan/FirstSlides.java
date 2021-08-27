package me.inventory.admin.augscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.app.StatusBarManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

public class FirstSlides extends AppCompatActivity {
    private ViewPager vpg;
    private LinearLayout la;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_slides);
        getSupportActionBar().hide();
        la = findViewById(R.id.dotsLayout);

        vpg = findViewById(R.id.vpg);
        sliderAdapter = new SliderAdapter(this);
        vpg.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        vpg.addOnPageChangeListener(viewListener);



    }

    public void next (View aa) {
        Intent intent1 = new Intent(FirstSlides.this, Step1.class);
        startActivity(intent1);
    }
    public void goprivacy(View aa){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://freeflixhqpro.com/privacy-policy/"));
        startActivity(viewIntent);

    }
    public void godisclamer(View aa){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://freeflixhqpro.com/disclaimer/"));
        startActivity(viewIntent);

    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        la.removeAllViews();
        for (int i=0;i< mDots.length; i++)
        {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(40);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentwhite));
            la.addView(mDots[i]);

        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }

    }



    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}