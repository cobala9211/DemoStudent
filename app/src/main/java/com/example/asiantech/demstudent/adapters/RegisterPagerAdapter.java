package com.example.asiantech.demstudent.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 02/02/2017.
 */
public class RegisterPagerAdapter extends PagerAdapter {
    private Context mContext;

    public RegisterPagerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView tvView = new TextView(mContext);
        tvView.setText("Item " + position);
        tvView.setGravity(Gravity.CENTER);
        tvView.setBackgroundColor(Color.BLUE);
        tvView.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));
        container.addView(tvView);
        return tvView;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
