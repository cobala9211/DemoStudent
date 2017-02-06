package com.example.asiantech.demstudent.fragment;

import android.os.Handler;

import com.example.asiantech.demstudent.R;

import org.androidannotations.annotations.EFragment;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 04/01/2017.
 */
@EFragment(R.layout.fragment_splash)
public class SplashFragment extends BaseFragment {
    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void initView() {
        displayScreen();

    }

    private void displayScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, SPLASH_TIME_OUT);
    }
}
