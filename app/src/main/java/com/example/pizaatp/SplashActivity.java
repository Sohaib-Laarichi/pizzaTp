package com.example.pizaatp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        progressBar = findViewById(R.id.progressBar);
        Thread thread = new Thread(){
            @Override
            public void run() {
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(5000);
                progressBar.startAnimation(rotateAnimation);
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Intent intent = new Intent(SplashActivity.this, ListPizzaActivity.class);
                startActivity(intent);
                finish();
            }
        };
        thread.start();
        thread2.start();
    }
}


