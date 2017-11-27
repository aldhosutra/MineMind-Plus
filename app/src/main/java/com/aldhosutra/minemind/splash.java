package com.aldhosutra.minemind;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // membuat intent activity
                Intent a = new Intent(getApplicationContext(), MainActivity.class);
                // start main activity dari context yang sudah dibuat
                startActivity(a);
                // menutup splash screen
                finish();
            }
        }, 2000); // untuk durasi splash screen mili detik
    }
}
