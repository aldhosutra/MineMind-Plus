package com.aldhosutra.minemind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RWIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rwintro);
    }

    public void goToRWQuiz(View v) {
        startActivity(new Intent(getApplicationContext(), RWQuiz.class));
    }
}
