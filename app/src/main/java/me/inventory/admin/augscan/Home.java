package me.inventory.admin.augscan;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.content.ContextCompat;
import androidx.core.view.MenuCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Home extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView phoneVersion;
    private String link = "https://dw.uptodown.com/dwn/zvea7jiLXYfqQdU1HLYs7tJzBvcYB5VF4rHaWvURY1iswDT9WwbiTgP5wp7X86OGsWlhdAfOC2bG1rSTNbGk5HCBIXLP2ElvGO_VKNOKWAWrUeXOMGAzRI-yNOBmDrr4/jYT10qD3ijPdAJP8kq70W68qWoF1HfVtBFwCFjSChuj-hUjbVSFGX_EVyvy4ghyXh5Avna8bB8HqGQ4DDtVLLsebs3Mk90uf_9LYC04QzqMPn-f4eVpbroe6KXHoLl8d/j3bOQNrP5T9lQE7rtYInZ22zab-b8Kt9MiTigbqRgmkDk0trC4XidfM1x3ROxv94IZvcYOTqV-06LZZHw3TjZg==/";
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        MaterialAlertDialogBuilder matbuilder = new MaterialAlertDialogBuilder(Home.this);
        matbuilder.setTitle("Alert Dialog!");
        matbuilder.setMessage("This Version is not compatible with "+getDeviceName());
        matbuilder.setCancelable(false);
        matbuilder.setPositiveButton("Download FreeFlix", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(link));
                startActivity(viewIntent);
            }
        });

        matbuilder.setBackground(ContextCompat.getDrawable(this ,R.color.light));




        matbuilder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.home, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

}