package com.example.managecasa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    ImageView appname;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        appname = findViewById(R.id.appname);
        lottie = findViewById(R.id.lottie);

        appname.animate().translationY(-1420).setDuration(1500).setStartDelay(0);
        lottie.animate().translationX(31).setDuration(2000).setStartDelay(2900);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();

            }
        }, 5000);
    }


}
