package com.aldhosutra.minemind;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IQQuiz extends AppCompatActivity {

    // membuat variabel untuk setiap widget

    int nomer_soal=1;

    Button btnSubmit;
    TextView soalCRT;
    TextView noSoal;

    int skor;

    EditText inputJwb;

    int jawabanSoal1;
    int jawabanSoal2;
    int jawabanSoal3;

    String isiSoalCRT[];

    AlertDialog alertDialog;

    AlertDialog areyousure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqquiz);

        // Init Variable dengan View
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        soalCRT = (TextView) findViewById(R.id.soalCRT);
        noSoal = (TextView) findViewById(R.id.noSoal);
        inputJwb = (EditText) findViewById(R.id.jawabanSoal);
        initExitDialog();

        // init soal awal
        initSoal();
        nomer_soal =1;
        soalCRT.setText(isiSoalCRT[nomer_soal-1]);
        noSoal.setText(" "+nomer_soal);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cek = inputJwb.getText().toString();
                if (cek.isEmpty()){
                    inputJwb.setError(getString(R.string.noNullInput));
                } else {
                    showSureDialog();
                }
            }
        });

    }

    private void updateView() {
        soalCRT.setText(isiSoalCRT[nomer_soal-1]);
        noSoal.setText(" "+nomer_soal);
        inputJwb.setText(null);

    }

    private void simpandanHitungInput() {
        if (nomer_soal==1) {
            jawabanSoal1 = Integer.parseInt(inputJwb.getText().toString());
            if (jawabanSoal1==5){
                skor++;
            } else {
                // Do nothing
            }
        } else if (nomer_soal==2){
            jawabanSoal2 = Integer.parseInt(inputJwb.getText().toString());
            if (jawabanSoal2==5){
                skor++;
            } else {
                // Do nothing
            }
        } else if (nomer_soal==3){
            jawabanSoal3 = Integer.parseInt(inputJwb.getText().toString());
            if (jawabanSoal3==47){
                skor++;
            } else {
                // Do nothing
            }
        }
    }

    private void initKirim() {
        Intent i = new Intent(getApplicationContext(),hasilIQ.class);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("skor", skor);
        editor.commit();

        startActivity(i);
    }

    private void initSoal() {
        // Ditambah 1 item asal, ga tau kenapa harus gitu wkwk
        isiSoalCRT = new String[] { getString(R.string.crtq1), getString(R.string.crtq2), getString(R.string.crtq3), " "};
    }

    private void initExitDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(getString(R.string.exitDialog));

        alertDialogBuilder.setNegativeButton(getString(R.string.yesDialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }

        });

        alertDialogBuilder.setPositiveButton(getString(R.string.noDialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // do nothing
            }

        });

        alertDialog = alertDialogBuilder.create();
    }

    private void showSureDialog() {
        AlertDialog.Builder sureDialog = new AlertDialog.Builder(this);
        sureDialog.setMessage(getString(R.string.areYouSure));

        sureDialog.setNegativeButton(getString(R.string.yesDialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                simpandanHitungInput();
                if (nomer_soal==3){
                    Toast.makeText(IQQuiz.this, getString(R.string.congratsQuizDone), Toast.LENGTH_SHORT).show();
                    initKirim();
                } else {
                    nomer_soal++;
                    updateView();
                }
            }

        });

        sureDialog.setPositiveButton(getString(R.string.noDialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // do nothing
            }

        });

        areyousure = sureDialog.create();
        areyousure.show();
    }

    @Override
    public void onBackPressed() {
        alertDialog.show();

    }

    public void sureHome(View v){
        alertDialog.show();
    }
}
