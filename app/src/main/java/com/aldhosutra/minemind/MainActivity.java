package com.aldhosutra.minemind;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pushwoosh.Pushwoosh;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AppIntro onCreate
        //  Declare a new thread to do a preference check
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("mulai", true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    Intent i = new Intent(MainActivity.this, intro.class);
                    startActivity(i);

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("mulai", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });

        // Start the thread
        t.start();

        Pushwoosh.getInstance().registerForPushNotifications();

    }

    public void goToQuiz(View v) {
        startActivity(new Intent(getApplicationContext(), QuizChoice.class));
    }

    public void goToPersonaChoice (View v){
        startActivity(new Intent(getApplicationContext(), PersonaChoice.class));
    }

    public void goToIQChoice(View v){
        startActivity(new Intent(getApplicationContext(), IQChoice.class));
    }

    public void goToAbout (View v) {
        startActivity(new Intent(getApplicationContext(),About.class));
    }

    public void showBahasa(View v) {
        AlertDialog alertDialog;

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(getString(R.string.bahasa));
        alertDialogBuilder.setTitle(getString(R.string.multiLang));

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // do nothing
            }

        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
