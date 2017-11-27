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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MCQuiz extends AppCompatActivity {

    // membuat variabel untuk setiap widget

    int nomer_soal=1;

    Button btnNext;
    TextView soalMC;
    TextView noSoal;
    RadioGroup rdGroup;
    RadioButton rd1,rd2,rd3,rd4,rd5,rdSelect;

    Boolean jawabannya;

    String isiSoalMC[];
    String isiOpsiA[];
    String isiOpsiB[];
    String isiOpsiC[];
    String isiOpsiD[];
    String isiOpsiE[];

    String jawabanTepat[];

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcquiz);

        // Init Variable dengan View
        btnNext = (Button) findViewById(R.id.btnNext);
        soalMC = (TextView) findViewById(R.id.soalMC);
        noSoal = (TextView) findViewById(R.id.noSoal);
        rdGroup = (RadioGroup) findViewById(R.id.rdGroup1);
        rd1 = (RadioButton) findViewById(R.id.radio1);
        rd2 = (RadioButton) findViewById(R.id.radio2);
        rd3 = (RadioButton) findViewById(R.id.radio3);
        rd4 = (RadioButton) findViewById(R.id.radio4);
        rd5 = (RadioButton) findViewById(R.id.radio5);

        initExitDialog();

        // init soal awal
        initSoal();
        nomer_soal =1;
        soalMC.setText(isiSoalMC[nomer_soal-1]);
        rd1.setText(isiOpsiA[nomer_soal-1]);
        rd2.setText(isiOpsiB[nomer_soal-1]);
        rd3.setText(isiOpsiC[nomer_soal-1]);
        rd4.setText(isiOpsiD[nomer_soal-1]);
        rd5.setText(isiOpsiE[nomer_soal-1]);
        noSoal.setText(" "+nomer_soal);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String jwbKode = "A"+nomer_soal;

                rdSelect = (RadioButton)findViewById(rdGroup.getCheckedRadioButtonId());

                if (rdSelect == rd1) {
                    jwbKode = "A"+nomer_soal;
                } else if (rdSelect == rd2) {
                    jwbKode = "B"+nomer_soal;
                } else if (rdSelect == rd3) {
                    jwbKode = "C"+nomer_soal;
                } else if (rdSelect == rd4) {
                    jwbKode = "D"+nomer_soal;
                } else if (rdSelect == rd5){
                    jwbKode = "E"+nomer_soal;
                }

                cekJawaban(jwbKode);

                noSoal.setText(" "+nomer_soal);

            }
        });
    }

    private void initKirim() {
        Intent i = new Intent(getApplicationContext(),hasilMC.class);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("nomersoal", nomer_soal);
        editor.commit();

        startActivity(i);
    }

    private void cekJawaban(String kode) {
        //Cek jawaban dengan array Jawaban Tepat
        if(cariString(kode,jawabanTepat)){
            jawabannya = true;

            if (nomer_soal==10){
                Toast.makeText(this, getString(R.string.congratsQuizDone), Toast.LENGTH_SHORT).show();
                initKirim();
            } else {
                Toast.makeText(this, getString(R.string.wowCorrect), Toast.LENGTH_SHORT).show();
                nomer_soal++;
                soalMC.setText(isiSoalMC[nomer_soal-1]);
                rd1.setText(isiOpsiA[nomer_soal-1]);
                rd2.setText(isiOpsiB[nomer_soal-1]);
                rd3.setText(isiOpsiC[nomer_soal-1]);
                rd4.setText(isiOpsiD[nomer_soal-1]);
                rd5.setText(isiOpsiE[nomer_soal-1]);
            }

        } else {
            Toast.makeText(this, getString(R.string.sorryIncorrect), Toast.LENGTH_SHORT).show();
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
        // Ga tau kenapa, tapi tambahin 1 item terakhir bebas, misal XXX
        isiSoalMC = new String[] {getString(R.string.mcq1),getString(R.string.mcq2),getString(R.string.mcq3),getString(R.string.mcq4),getString(R.string.mcq5),
                getString(R.string.mcq6),getString(R.string.mcq7),getString(R.string.mcq8),getString(R.string.mcq9),getString(R.string.mcq10),"XX"};

        // Sama disini pun semuanya di tambagin 1 item tambahan bebas
        isiOpsiA = new String[] {getString(R.string.mcA1),getString(R.string.mcA2),getString(R.string.mcA3),getString(R.string.mcA4),getString(R.string.mcA5),
                getString(R.string.mcA6),getString(R.string.mcA7),getString(R.string.mcA8),getString(R.string.mcA9),getString(R.string.mcA10),"XX"};
        isiOpsiB = new String[] {getString(R.string.mcB1),getString(R.string.mcB2),getString(R.string.mcB3),getString(R.string.mcB4),getString(R.string.mcB5),
                getString(R.string.mcB6),getString(R.string.mcB7),getString(R.string.mcB8),getString(R.string.mcB9),getString(R.string.mcB10),"XX"};
        isiOpsiC = new String[] {getString(R.string.mcC1),getString(R.string.mcC2),getString(R.string.mcC3),getString(R.string.mcC4),getString(R.string.mcC5),
                getString(R.string.mcC6),getString(R.string.mcC7),getString(R.string.mcC8),getString(R.string.mcC9),getString(R.string.mcC10),"XX"};
        isiOpsiD = new String[] {getString(R.string.mcD1),getString(R.string.mcD2),getString(R.string.mcD3),getString(R.string.mcD4),getString(R.string.mcD5),
                getString(R.string.mcD6),getString(R.string.mcD7),getString(R.string.mcD8),getString(R.string.mcD9),getString(R.string.mcD10),"XX"};
        isiOpsiE = new String[] {getString(R.string.mcE1),getString(R.string.mcE2),getString(R.string.mcE3),getString(R.string.mcE4),getString(R.string.mcE5),
                getString(R.string.mcE6),getString(R.string.mcE7),getString(R.string.mcE8),getString(R.string.mcE9),getString(R.string.mcE10),"XX"};

        jawabanTepat = new String[] {"C1","A2","C3","C4","B5","B6","A7","D8","B9","D10","XX"};

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
