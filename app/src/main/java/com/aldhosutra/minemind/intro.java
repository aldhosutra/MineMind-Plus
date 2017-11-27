package com.aldhosutra.minemind;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class intro extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance(getString(R.string.slide1a), getString(R.string.slide1b),
                R.drawable.hello, Color.parseColor("#e91e63")));

        addSlide(AppIntroFragment.newInstance(getString(R.string.slide2a), getString(R.string.slide2b),
                R.drawable.ic_test, Color.parseColor("#212121")));

        addSlide(AppIntroFragment.newInstance(getString(R.string.slide3a), getString(R.string.slide3b),
                R.drawable.flag, Color.parseColor("#ffc107")));

        addSlide(AppIntroFragment.newInstance(getString(R.string.slide4a), getString(R.string.slide4b),
                R.drawable.slideshare, Color.parseColor("#212121")));

        addSlide(AppIntroFragment.newInstance(getString(R.string.slide5a), getString(R.string.slide5b),
                R.drawable.kejar, Color.parseColor("#e91e63")));

        showSkipButton(false);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        loadMainActivity();
    }

    void loadMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
