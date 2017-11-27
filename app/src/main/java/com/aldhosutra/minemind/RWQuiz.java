package com.aldhosutra.minemind;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RWQuiz extends AppCompatActivity {

    // membuat variabel untuk setiap widget

    int nomer_soal=1;

    Button btnBenar;
    Button btnSalah;
    Button okButt;
    TextView soalRW;
    TextView noSoal;
    TextView keterangan;
    TextView txtScore;
    LinearLayout layoutButton;

    Boolean jawabannya;

    String isiSoalRW[];
    String isiFakta[];

    String jawabanTepat[];

    int score;

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rwquiz);

        // Init Variable dengan View
        btnBenar = (Button) findViewById(R.id.btnBenar);
        btnSalah = (Button) findViewById(R.id.btnSalah);
        soalRW = (TextView) findViewById(R.id.soalRW);
        noSoal = (TextView) findViewById(R.id.noSoal);
        keterangan = (TextView) findViewById(R.id.ketJawaban);
        okButt = (Button) findViewById(R.id.okButton);
        txtScore = (TextView) findViewById(R.id.score);
        layoutButton = (LinearLayout) findViewById(R.id.lay2Button);
        initExitDialog();

        // init soal awal
        initSoal();
        nomer_soal =1;
        soalRW.setText(isiSoalRW[nomer_soal-1]);
        noSoal.setText(" "+nomer_soal);

        btnBenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String kode = "A"+nomer_soal;
                cekJawaban(kode);
                showFakta();
                nomer_soal++;

            }
        });

        btnSalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String kode = "B"+nomer_soal;
                cekJawaban(kode);
                showFakta();
                nomer_soal++;

            }
        });

        okButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // nomer soalnya +1 dari nilai asli

                if (nomer_soal==51) {
                    Toast.makeText(RWQuiz.this, getString(R.string.congratsQuizDone), Toast.LENGTH_SHORT).show();
                    initKirim();
                } else {
                    showQuiz();
                }
            }
        });
    }

    private void showFakta() {

        if (jawabannya) {
            keterangan.setText(R.string.correctAnswer);
        } else {
            keterangan.setText(R.string.wrongAnswer);
        }

        okButt.setVisibility(View.VISIBLE);
        keterangan.setVisibility(View.VISIBLE);
        btnBenar.setVisibility(View.GONE);
        btnSalah.setVisibility(View.GONE);
        layoutButton.setVisibility(View.GONE);
        soalRW.setText(isiFakta[nomer_soal-1]);
        txtScore.setText(" "+score);
    }

    private void showQuiz(){
        keterangan.setVisibility(View.INVISIBLE);
        soalRW.setText(isiSoalRW[nomer_soal-1]);
        okButt.setVisibility(View.GONE);
        btnBenar.setVisibility(View.VISIBLE);
        btnSalah.setVisibility(View.VISIBLE);
        layoutButton.setVisibility(View.VISIBLE);
        noSoal.setText(" "+nomer_soal);
    }

    private void initKirim() {
        Intent i = new Intent(getApplicationContext(),hasilRW.class);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("score", score);
        editor.commit();

        startActivity(i);
    }

    private void cekJawaban(String kode) {
        //Cek jawaban dengan array Jawaban Tepat
        if(cariString(kode,jawabanTepat)){
            score = score + 2;
            jawabannya = true;

        } else {
            score = score -1;
            jawabannya = false;
        }
    }

    private boolean cariString(String kode, String[] jawabanTepat) {
        int banyakPencarian = jawabanTepat.length;
        boolean dapetKodeJawaban=false;

        for (int i=0;i<banyakPencarian;i++){
            if (kode.equals(jawabanTepat[i])){
                dapetKodeJawaban = true;
                break;
            }
        }

        return dapetKodeJawaban;
    }

    private void initSoal() {
        isiSoalRW = new String[] { getString(R.string.rwq1), getString(R.string.rwq2), getString(R.string.rwq3), getString(R.string.rwq4), getString(R.string.rwq5),
                getString(R.string.rwq6), getString(R.string.rwq7), getString(R.string.rwq8), getString(R.string.rwq9), getString(R.string.rwq10),
                getString(R.string.rwq11), getString(R.string.rwq12), getString(R.string.rwq13), getString(R.string.rwq14), getString(R.string.rwq15),
                getString(R.string.rwq16), getString(R.string.rwq17), getString(R.string.rwq18), getString(R.string.rwq19), getString(R.string.rwq20),
                getString(R.string.rwq21), getString(R.string.rwq22), getString(R.string.rwq23), getString(R.string.rwq24), getString(R.string.rwq25),
                getString(R.string.rwq26), getString(R.string.rwq27), getString(R.string.rwq28), getString(R.string.rwq29), getString(R.string.rwq30),
                getString(R.string.rwq31), getString(R.string.rwq32), getString(R.string.rwq33), getString(R.string.rwq34), getString(R.string.rwq35),
                getString(R.string.rwq36), getString(R.string.rwq37), getString(R.string.rwq38), getString(R.string.rwq39), getString(R.string.rwq40),
                getString(R.string.rwq41), getString(R.string.rwq42), getString(R.string.rwq43), getString(R.string.rwq44), getString(R.string.rwq45),
                getString(R.string.rwq46), getString(R.string.rwq47), getString(R.string.rwq48), getString(R.string.rwq49), getString(R.string.rwq50)};

        isiFakta = new String[] { getString(R.string.rwf1), getString(R.string.rwf2), getString(R.string.rwf3), getString(R.string.rwf4), getString(R.string.rwf5),
                getString(R.string.rwf6), getString(R.string.rwf7), getString(R.string.rwf8), getString(R.string.rwf9), getString(R.string.rwf10),
                getString(R.string.rwf11), getString(R.string.rwf12), getString(R.string.rwf13), getString(R.string.rwf14), getString(R.string.rwf15),
                getString(R.string.rwf16), getString(R.string.rwf17), getString(R.string.rwf18), getString(R.string.rwf19), getString(R.string.rwf20),
                getString(R.string.rwf21), getString(R.string.rwf22), getString(R.string.rwf23), getString(R.string.rwf24), getString(R.string.rwf25),
                getString(R.string.rwf26), getString(R.string.rwf27), getString(R.string.rwf28), getString(R.string.rwf29), getString(R.string.rwf30),
                getString(R.string.rwf31), getString(R.string.rwf32), getString(R.string.rwf33), getString(R.string.rwf34), getString(R.string.rwf35),
                getString(R.string.rwf36), getString(R.string.rwf37), getString(R.string.rwf38), getString(R.string.rwf39), getString(R.string.rwf40),
                getString(R.string.rwf41), getString(R.string.rwf42), getString(R.string.rwf43), getString(R.string.rwf44), getString(R.string.rwf45),
                getString(R.string.rwf46), getString(R.string.rwf47), getString(R.string.rwf48), getString(R.string.rwf49), getString(R.string.rwf50)};

        jawabanTepat = new String[] {"B1","B2","A3","A4","B5","B6","B7","A8","A9","A10","B11","B12","B13","B14","B15","A16","A17","B18","B19","B20","A21","B22","B23","B24","B25",",A26","B27","A28","A29","B30","A31","A32","B33","A34","A35","A36","A37","B38","A39","A40","A41","B42","B43","A44","B45","B46","B47","B48","B49","B50"};

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

    @Override
    public void onBackPressed() {
        alertDialog.show();

    }

    public void sureHome(View v){
        alertDialog.show();
    }
}
