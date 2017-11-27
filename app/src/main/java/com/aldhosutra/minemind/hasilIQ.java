package com.aldhosutra.minemind;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class hasilIQ extends AppCompatActivity {

    int skor;

    String hasil;

    TextView txtHasil,txtPenjelasan,txtHebat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_iq);

        txtHasil = (TextView)findViewById(R.id.kodePersona);
        txtPenjelasan = (TextView)findViewById(R.id.lengkapCRT);
        txtHebat = (TextView)findViewById(R.id.kodeHebat);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);

        skor = prefs.getInt("skor", 0);

        txtHebat.setText(getString(R.string.corrAnswer)+" "+skor);

        if(skor>1){
            txtHasil.setText(getString(R.string.cogThinker));
            txtPenjelasan.setText(getString(R.string.crtPos));
        } else {
            txtHasil.setText(getString(R.string.intuiThinker));
            txtPenjelasan.setText(getString(R.string.crtNo));
        }
    }

    public void goToHome(View v) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    
    @Override
    public void onBackPressed() {
        Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nextScreen);
    }

    public void shareHasilIQ(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.resultIQ1) + " " + txtHasil.getText().toString() + getString(R.string.resultIQ2));
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getString(R.string.shareUsing)));
    }
}
