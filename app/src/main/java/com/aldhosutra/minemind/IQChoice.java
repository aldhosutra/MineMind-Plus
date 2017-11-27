package com.aldhosutra.minemind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class IQChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqchoice);
    }

    public void goToIQIntro(View v){
        Toast.makeText(this, getString(R.string.introQuiz), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),IQIntro.class));
    }
}
