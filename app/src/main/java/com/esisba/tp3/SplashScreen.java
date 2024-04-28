package com.esisba.tp3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    ImageView splashIMG;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashIMG = findViewById(R.id.splashIMG);
        applyAnimation(splashIMG);
        goToNextPage();
    }

    private void applyAnimation(ImageView img) {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        img.startAnimation(rotateAnimation);
    }

    private void goToNextPage() {
        splashIMG.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }
}
