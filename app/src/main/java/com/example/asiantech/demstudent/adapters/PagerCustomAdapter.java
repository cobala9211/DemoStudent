package com.example.asiantech.demstudent.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.asiantech.demstudent.fragment.custom_view.CurrentFragment_;


/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 02/02/2017.
 */
public class PagerCustomAdapter extends FragmentStatePagerAdapter {
    public PagerCustomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return CurrentFragment_.builder().build();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public float getPageWidth(int position) {
        if (position == 0 || position == 4) {
            return 0;
        }
        return 1f;
    }
}
