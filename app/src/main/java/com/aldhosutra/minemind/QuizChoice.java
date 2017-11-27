package com.aldhosutra.minemind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class QuizChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_choice);
    }

    public void goToRWIntro (View v) {
        startActivity(new Intent(getApplicationContext(), RWIntro.class));
        Toast.makeText(this, R.string.introQuiz, Toast.LENGTH_SHORT).show();
    }

    public void goToMCIntro (View v) {
        startActivity(new Intent(getApplicationContext(), MCIntro.class));
        Toast.makeText(this, R.string.introQuiz, Toast.LENGTH_SHORT).show();
    }
}
