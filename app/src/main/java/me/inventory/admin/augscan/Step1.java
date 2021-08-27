package me.inventory.admin.augscan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Step1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);
        getSupportActionBar().hide();
    }
}