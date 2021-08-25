package me.inventory.admin.augscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.LinearLayout;

import com.google.android.material.appbar.AppBarLayout;

public class FirstSlides extends AppCompatActivity {
    private ViewPager vpg;
    private LinearLayout la;
    private SliderAdapter sliderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_slides);
        getSupportActionBar().hide();

        vpg = findViewById(R.id.vpg);
        sliderAdapter = new SliderAdapter(this);
        vpg.setAdapter(sliderAdapter);


    }
}