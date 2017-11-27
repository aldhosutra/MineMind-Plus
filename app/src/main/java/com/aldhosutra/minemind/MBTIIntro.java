package com.aldhosutra.minemind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MBTIIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiintro);
    }

    public void goToMBTIQuiz(View v){
        startActivity(new Intent(getApplicationContext(),MBTIQuiz.class));
    }
}
