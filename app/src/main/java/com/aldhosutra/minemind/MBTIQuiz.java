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
import android.widget.TextView;

public class MBTIQuiz extends AppCompatActivity {

    int nomer_soal=1;

    Button btnSoalA;
    Button btnSoalB;
    TextView soalA;
    TextView soalB;
    TextView noSoal;

    String isiSoalA[];
    String isiSoalB[];
    String tipeSoalIntrovert[];
    String tipeSoalSensing[];
    String tipeSoalThingking[];
    String tipeSoalJudging[];
    String tipeSoalEkstrovert[];
    String tipeSoalIntuition[];
    String tipeSoalFeeling[];
    String tipeSoalPerceiving[];
    int introvert, sensing, thinking, judging, ekstrovert, intuition, feeling, perceiving;

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiquiz);

        soalA = (TextView) findViewById(R.id.SoalA);
        soalB = (TextView) findViewById(R.id.SoalB);
        noSoal = (TextView) findViewById(R.id.noSoal);
        btnSoalA = (Button) findViewById(R.id.btnA);
        btnSoalB = (Button) findViewById(R.id.btnB);
        bikinDialog();

        //Init Isi Awal
        initSoal();
        nomer_soal =1;
        soalA.setText(isiSoalA[nomer_soal-1]);
        soalB.setText(isiSoalB[nomer_soal-1]);
        noSoal.setText(" "+nomer_soal);


        btnSoalA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String kode = "A"+nomer_soal;
                cekJawaban(kode);

                if(nomer_soal==60){

                    initKirim();

                } else{
                    nomer_soal++;
                    updateView();
                }


            }
        });

        btnSoalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String kode = "B"+nomer_soal;
                cekJawaban(kode);

                if(nomer_soal==60){

                    initKirim();

                } else{
                    nomer_soal++;
                    updateView();
                }

            }
        });

    }

    public void bikinDialog(){
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
                //Toast.makeText(getApplicationContext(), "You clicked yes button", Toast.LENGTH_LONG).show();
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


    public void cekJawaban(String kode){

        //Ngecek Introvert
        if(cariString(kode,tipeSoalIntrovert)){
            introvert++;
        } else

            //Ngecek Ekstrovert
            if(cariString(kode,tipeSoalEkstrovert)){
                ekstrovert++;
            } else

                //Ngecek Sensing
                if(cariString(kode,tipeSoalSensing)){
                    sensing++;
                } else

                    //Ngecek Thinking
                    if(cariString(kode,tipeSoalThingking)){
                        thinking++;
                    } else

                        //Ngecek Judging
                        if(cariString(kode,tipeSoalJudging)){
                            judging++;
                        } else

                            //Ngecek Intuition
                            if(cariString(kode,tipeSoalIntuition)){
                                intuition++;
                            } else

                                //Ngecek Feeling
                                if(cariString(kode,tipeSoalFeeling)){
                                    feeling++;
                                } else

                                    //Ngecek Perceiving
                                    if(cariString(kode,tipeSoalPerceiving)){
                                        perceiving++;
                                    }

    }

    public void initSoal(){
        isiSoalA = new String[] {getString(R.string.mbtiA1),getString(R.string.mbtiA2),getString(R.string.mbtiA3),getString(R.string.mbtiA4),getString(R.string.mbtiA5), 
                getString(R.string.mbtiA6),getString(R.string.mbtiA7),getString(R.string.mbtiA8),getString(R.string.mbtiA9),getString(R.string.mbtiA10),
                getString(R.string.mbtiA11),getString(R.string.mbtiA12),getString(R.string.mbtiA13),getString(R.string.mbtiA14),getString(R.string.mbtiA15),
                getString(R.string.mbtiA16),getString(R.string.mbtiA17),getString(R.string.mbtiA18),getString(R.string.mbtiA19),getString(R.string.mbtiA20),
                getString(R.string.mbtiA21),getString(R.string.mbtiA22),getString(R.string.mbtiA23),getString(R.string.mbtiA24),getString(R.string.mbtiA25),
                getString(R.string.mbtiA6),getString(R.string.mbtiA7),getString(R.string.mbtiA28),getString(R.string.mbtiA29),getString(R.string.mbtiA30),
                getString(R.string.mbtiA31),getString(R.string.mbtiA32),getString(R.string.mbtiA33),getString(R.string.mbtiA34),getString(R.string.mbtiA35),
                getString(R.string.mbtiA36),getString(R.string.mbtiA37),getString(R.string.mbtiA38),getString(R.string.mbtiA39),getString(R.string.mbtiA40),
                getString(R.string.mbtiA41),getString(R.string.mbtiA42),getString(R.string.mbtiA43),getString(R.string.mbtiA44),getString(R.string.mbtiA45),
                getString(R.string.mbtiA46),getString(R.string.mbtiA7),getString(R.string.mbtiA48),getString(R.string.mbtiA49),getString(R.string.mbtiA50),
                getString(R.string.mbtiA51),getString(R.string.mbtiA52),getString(R.string.mbtiA53),getString(R.string.mbtiA54),getString(R.string.mbtiA55),
                getString(R.string.mbtiA56),getString(R.string.mbtiA57),getString(R.string.mbtiA58),getString(R.string.mbtiA59),getString(R.string.mbtiA60)};

        isiSoalB = new String[] {getString(R.string.mbtiB1),getString(R.string.mbtiB2),getString(R.string.mbtiB3),getString(R.string.mbtiB4),getString(R.string.mbtiB5),
                getString(R.string.mbtiB6),getString(R.string.mbtiB7),getString(R.string.mbtiB8),getString(R.string.mbtiB9),getString(R.string.mbtiB10),
                getString(R.string.mbtiB11),getString(R.string.mbtiB12),getString(R.string.mbtiB13),getString(R.string.mbtiB14),getString(R.string.mbtiB15),
                getString(R.string.mbtiB16),getString(R.string.mbtiB17),getString(R.string.mbtiB18),getString(R.string.mbtiB19),getString(R.string.mbtiB20),
                getString(R.string.mbtiB21),getString(R.string.mbtiB22),getString(R.string.mbtiB23),getString(R.string.mbtiB24),getString(R.string.mbtiB25),
                getString(R.string.mbtiB6),getString(R.string.mbtiB7),getString(R.string.mbtiB28),getString(R.string.mbtiB29),getString(R.string.mbtiB30),
                getString(R.string.mbtiB31),getString(R.string.mbtiB32),getString(R.string.mbtiB33),getString(R.string.mbtiB34),getString(R.string.mbtiB35),
                getString(R.string.mbtiB36),getString(R.string.mbtiB37),getString(R.string.mbtiB38),getString(R.string.mbtiB39),getString(R.string.mbtiB40),
                getString(R.string.mbtiB41),getString(R.string.mbtiB42),getString(R.string.mbtiB43),getString(R.string.mbtiB44),getString(R.string.mbtiB45),
                getString(R.string.mbtiB46),getString(R.string.mbtiB7),getString(R.string.mbtiB48),getString(R.string.mbtiB49),getString(R.string.mbtiB50),
                getString(R.string.mbtiB51),getString(R.string.mbtiB52),getString(R.string.mbtiB53),getString(R.string.mbtiB54),getString(R.string.mbtiB55),
                getString(R.string.mbtiB56),getString(R.string.mbtiB57),getString(R.string.mbtiB58),getString(R.string.mbtiB59),getString(R.string.mbtiB60)};
        
        tipeSoalIntrovert = new String[] {"B60","B52","A45","A38","B35","A31","A29","B28","A20","A15","A11","A10","B7","B5","A2"};
        tipeSoalEkstrovert = new String[] {"A60","A52","B45","B38","A35","B31","B29","A28","B20","B15","B11","B10","A7","A5","B2"};
        tipeSoalSensing = new String[] {"A53","A51","A46","A43","A41","A36","A34","A27","A25","B22","B18","A16","A13","A8","B6"};
        tipeSoalIntuition = new String[] {"B53","B51","B46","B43","B41","B36","B34","B27","B25","A22","A18","B16","B13","B8","A6"};
        tipeSoalThingking = new String[] {"A58","A57","A55","B49","A48","A42","B39","A37","A23","B32","A30","A17","B9","A4","A14"};
        tipeSoalFeeling = new String[] {"B58","B57","B55","A49","B48","B42","A39","B37","A32","B30","B23","B17","B14","A9","B4"};
        tipeSoalJudging = new String[] {"B59","A56","A54","B50","A47","B44","B40","B33","B26","A24","B21","A19","B12","A3","B1"};
        tipeSoalPerceiving = new String[] {"A59","B56","B54","A50","B47","A44","A40","A33","A26","B24","A21","B19","A12","B3","A1"};
    }

    public boolean cariString(String kode, String[] tipeSoal){
        int banyakPencarian = tipeSoal.length;
        boolean dapetKode=false;

        for (int i=0;i<banyakPencarian;i++){
            if (kode.equals(tipeSoal[i])){
                dapetKode = true;
                break;
            }
        }

        return dapetKode;
    }

    public void updateView(){
        soalA.setText(isiSoalA[nomer_soal-1]);
        soalB.setText(isiSoalB[nomer_soal-1]);
        noSoal.setText(" "+nomer_soal);
    }

    public void initKirim(){
        Intent i = new Intent(getApplicationContext(),hasilMBTI.class);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("introvert", introvert);
        editor.putInt("ekstrovert", ekstrovert);
        editor.putInt("sensing", sensing);
        editor.putInt("intuition", intuition);
        editor.putInt("thinking", thinking);
        editor.putInt("feeling", feeling);
        editor.putInt("judging", judging);
        editor.putInt("perceiving",perceiving);
        editor.commit();

        startActivity(i);


    }
}
