package com.aldhosutra.minemind;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hasilMBTI extends AppCompatActivity {

    int introvert, sensing, thinking, judging, ekstrovert, intuition, feeling, perceiving;
    TextView kodePerson;
    TextView nickPerson;
    String kode,k1,k2,k3,k4;
    Character kode1,kode2,kode3,kode4;
    TextView txtSifat,txtSaranP,txtSaranF,txtPartner,lengkap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_mbti);

        kodePerson = (TextView) findViewById(R.id.kodePersona);
        nickPerson = (TextView) findViewById(R.id.nickPersona);

        txtSifat = (TextView) findViewById(R.id.txtSifat);
        txtSaranP = (TextView) findViewById(R.id.txtSaranP);
        txtSaranF = (TextView) findViewById(R.id.txtSaranF);
        txtPartner = (TextView) findViewById(R.id.txtPartner);
        lengkap = (TextView) findViewById(R.id.lengkapPersona);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);

        introvert = prefs.getInt("introvert", 0);
        ekstrovert = prefs.getInt("ekstrovert", 0);
        sensing = prefs.getInt("sensing", 0);
        thinking = prefs.getInt("thinking", 0);
        judging = prefs.getInt("judging", 0);
        intuition = prefs.getInt("intuition", 0);
        feeling = prefs.getInt("feeling", 0);
        perceiving = prefs.getInt("perceiving",0);
        final int totalSoal= introvert+ekstrovert+sensing+thinking+judging+intuition+feeling+perceiving;

        final String hasil = cekHasilFinal();
        kode = hasil;

        UpdatePersona();

        kode1= kode.charAt(0);
        kode2= kode.charAt(1);
        kode3= kode.charAt(2);
        kode4= kode.charAt(3);

        if(kode1 == 'i'){
            k1="Introvert";
        } else {
            k1="Extrovert";
        }

        if(kode2 == 's'){
            k2="Sensing";
        } else {
            k2="Intuitive";
        }

        if(kode3 == 't'){
            k3="Thinking";
        } else {
            k3="Feeling";
        }

        if(kode4 == 'j'){
            k4="Judging";
        } else {
            k4="Perceiving";
        }

        kodePerson.setText(hasil.toUpperCase());
        lengkap.setText(k1+" "+k2+" "+k3+" "+k4);
    }

    private void UpdatePersona() {
        switch (kode){
            case"istj":
                txtSifat.setText(R.string.istj_sifat);
                txtSaranP.setText(R.string.istj_saranp);
                txtSaranF.setText(R.string.istj_saranf);
                txtPartner.setText(R.string.istj_partner);
                nickPerson.setText(R.string.istj_ket);
                break;

            case"isfj":
                txtSifat.setText(R.string.isfj_sifat);
                txtSaranP.setText(R.string.isfj_saranp);
                txtSaranF.setText(R.string.isfj_saranf);
                txtPartner.setText(R.string.isfj_partner);
                nickPerson.setText(R.string.isfj_ket);
                break;

            case"istp":
                txtSifat.setText(R.string.istp_sifat);
                txtSaranP.setText(R.string.istp_saranp);
                txtSaranF.setText(R.string.istp_saranf);
                txtPartner.setText(R.string.istp_partner);
                nickPerson.setText(R.string.istp_ket);
                break;

            case"isfp":
                txtSifat.setText(R.string.isfp_sifat);
                txtSaranP.setText(R.string.isfp_saranp);
                txtSaranF.setText(R.string.isfp_saranf);
                txtPartner.setText(R.string.isfp_partner);
                nickPerson.setText(R.string.isfp_ket);
                break;

            case"infj":
                txtSifat.setText(R.string.infj_sifat);
                txtSaranP.setText(R.string.infj_saranp);
                txtSaranF.setText(R.string.infj_saranf);
                txtPartner.setText(R.string.infj_partner);
                nickPerson.setText(R.string.infj_ket);
                break;

            case"intj":
                txtSifat.setText(R.string.intj_sifat);
                txtSaranP.setText(R.string.intj_saranp);
                txtSaranF.setText(R.string.intj_saranf);
                txtPartner.setText(R.string.intj_partner);
                nickPerson.setText(R.string.intj_ket);
                break;

            case"infp":
                txtSifat.setText(R.string.infp_sifat);
                txtSaranP.setText(R.string.infp_saranp);
                txtSaranF.setText(R.string.infp_saranf);
                txtPartner.setText(R.string.infp_partner);
                nickPerson.setText(R.string.infp_ket);
                break;

            case"intp":
                txtSifat.setText(R.string.intp_sifat);
                txtSaranP.setText(R.string.intp_saranp);
                txtSaranF.setText(R.string.intp_saranf);
                txtPartner.setText(R.string.intp_partner);
                nickPerson.setText(R.string.intp_ket);
                break;

            case"estp":
                txtSifat.setText(R.string.estp_sifat);
                txtSaranP.setText(R.string.estp_saranp);
                txtSaranF.setText(R.string.estp_saranf);
                txtPartner.setText(R.string.estp_partner);
                nickPerson.setText(R.string.estp_ket);
                break;

            case"esfp":
                txtSifat.setText(R.string.esfp_sifat);
                txtSaranP.setText(R.string.esfp_saranp);
                txtSaranF.setText(R.string.esfp_saranf);
                txtPartner.setText(R.string.esfp_partner);
                nickPerson.setText(R.string.esfp_ket);
                break;

            case"enfp":
                txtSifat.setText(R.string.enfp_sifat);
                txtSaranP.setText(R.string.enfp_saranp);
                txtSaranF.setText(R.string.enfp_saranf);
                txtPartner.setText(R.string.enfp_partner);
                nickPerson.setText(R.string.enfp_ket);
                break;

            case"entp":
                txtSifat.setText(R.string.entp_sifat);
                txtSaranP.setText(R.string.entp_saranp);
                txtSaranF.setText(R.string.entp_saranf);
                txtPartner.setText(R.string.entp_partner);
                nickPerson.setText(R.string.entp_ket);
                break;

            case"estj":
                txtSifat.setText(R.string.estj_sifat);
                txtSaranP.setText(R.string.estj_saranp);
                txtSaranF.setText(R.string.estj_saranf);
                txtPartner.setText(R.string.estj_partner);
                nickPerson.setText(R.string.estj_ket);
                break;

            case"esfj":
                txtSifat.setText(R.string.esfj_sifat);
                txtSaranP.setText(R.string.esfj_saranp);
                txtSaranF.setText(R.string.esfj_saranf);
                txtPartner.setText(R.string.esfj_partner);
                nickPerson.setText(R.string.esfj_ket);
                break;

            case"enfj":
                txtSifat.setText(R.string.enfj_sifat);
                txtSaranP.setText(R.string.enfj_saranp);
                txtSaranF.setText(R.string.enfj_saranf);
                txtPartner.setText(R.string.enfj_partner);
                nickPerson.setText(R.string.enfj_ket);
                break;

            case"entj":
                txtSifat.setText(R.string.entj_sifat);
                txtSaranP.setText(R.string.entj_saranp);
                txtSaranF.setText(R.string.entj_saranf);
                txtPartner.setText(R.string.entj_partner);
                nickPerson.setText(R.string.entj_ket);
                break;
        }

    }


    public String cekHasilFinal(){
        String hasil;

        if (introvert>=ekstrovert){
            hasil="i";
        } else {
            hasil="e";
        }
        if (sensing>=intuition){
            hasil=hasil+"s";
        } else {
            hasil=hasil+"n";
        }
        if (thinking>=feeling){
            hasil=hasil+"t";
        } else {
            hasil=hasil+"f";
        }
        if (judging>=perceiving){
            hasil=hasil+"j";
        } else{
            hasil=hasil+"p";
        }
        return hasil;
    }

    public String cekDeskripsi(String kode){
        String returnHore = null;

        switch (kode){
            case "istj" :
                returnHore="Bertanggungjawab";
                break;

            case "isfj" :
                returnHore="Setia";
                break;

            case "istp" :
                returnHore="Pragmatis";
                break;

            case "isfp" :
                returnHore="Artistik";
                break;

            case "infj" :
                returnHore="Reflektif";
                break;

            case "intj" :
                returnHore="Independen";
                break;

            case "infp" :
                returnHore="Idealis";
                break;

            case "intp" :
                returnHore="Konseptual";
                break;

            case "estp" :
                returnHore="Spontan";
                break;

            case "esfp" :
                returnHore="Murah Hati";
                break;

            case "enfp" :
                returnHore="Optimis";
                break;

            case "entp" :
                returnHore="Inovatif - Kreatif";
                break;

            case "estj" :
                returnHore="Konservatif - Disiplin";
                break;

            case "esf" :
                returnHore="Harmoni";
                break;

            case "enfj" :
                returnHore="Meyakinkan";
                break;

            case "entj" :
                returnHore="Pemimpin Alami";
                break;

            default:
                returnHore="Great!";


        }


        return returnHore;
    }

    @Override
    public void onBackPressed() {
        Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nextScreen);
    }
    public void goToHome(View v) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    public void shareHasilMBTI(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.resultMBTI1) + " " + kodePerson.getText().toString().toUpperCase() + getString(R.string.resultMBTI2));
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getString(R.string.shareUsing)));
    }

}
