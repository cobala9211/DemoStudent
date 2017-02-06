package com.example.asiantech.demstudent.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;

import java.util.Random;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 06/01/2017.
 */
public class CustomLayout extends RelativeLayout {
    public TextView mTvNumTotal;
    public TextView mTvNumPro;
    public CustomProgressBar mProgressBar;

    private String mStringNumPro;
    private String mStringNumTotal;
    private int mTextSizeTotal;
    private int mTextSizePro;
    private int mProWith;
    private int mProgress;
    private int mColorProgress;
    private int mColorBackground;
    private int mColorText;
    private int color = Color.BLACK;

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
        addTextView(context, attrs);
    }


    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.customLayout, 0, 0);
        try {
            mStringNumPro = typedArray.getString(R.styleable.customLayout_cl_text_string_pro);
            mStringNumTotal = typedArray.getString(R.styleable.customLayout_cl_text_string_total);
            mTextSizePro = typedArray.getInt(R.styleable.customLayout_cl_text_size_pro, 0);
            mTextSizeTotal = typedArray.getInt(R.styleable.customLayout_cl_text_size_total, 0);
            mProWith = typedArray.getInt(R.styleable.customLayout_cl_progressbar_width, 0);
            mProgress = typedArray.getInt(R.styleable.customLayout_cl_progress, 0);
            mColorProgress = typedArray.getInt(R.styleable.customLayout_cl_progressbar_color, 0);
            mColorBackground = typedArray.getInt(R.styleable.customLayout_cl_background_color, color);
            mColorText = typedArray.getInt(R.styleable.customLayout_cl_text_color, color);

        } finally {
            typedArray.recycle();
        }

    }

    private void addTextView(Context context, AttributeSet attrs) {

        mProgressBar = new CustomProgressBar(context, attrs);
        mProgressBar.setId(generateViewId(mProgressBar));
        mProgressBar.setBackgroundProgressBarWidth(mProWith);
        mProgressBar.setProgressBarWidth(mProWith);
        mProgressBar.setColor(mColorProgress);
        mProgressBar.setBackgroundColor(mColorBackground);
        int animationDuration = 2500;
        mProgressBar.setProgressWithAnimation(mProgress, animationDuration);


        mTvNumTotal = new TextView(context);
        mTvNumTotal.setText(mStringNumTotal);
        mTvNumTotal.setTextColor(Color.BLACK);
        mTvNumTotal.setTextSize(mTextSizeTotal);
        mTvNumTotal.setId(generateViewId(mTvNumTotal));
        mTvNumTotal.setTypeface(null, Typeface.BOLD);
        mTvNumTotal.setTextColor(mColorText);

        mTvNumPro = new TextView(context);
        mTvNumPro.setText(mStringNumPro);
        mTvNumPro.setTextColor(Color.BLACK);
        mTvNumPro.setId(generateViewId(mTvNumPro));
        mTvNumPro.setTextSize(mTextSizePro);
        mTvNumPro.setTextColor(mColorText);

        this.addView(mProgressBar);
        RelativeLayout.LayoutParams paramProgress = (LayoutParams) mProgressBar.getLayoutParams();
        paramProgress.addRule(RelativeLayout.CENTER_IN_PARENT);


        RelativeLayout rlContents = new RelativeLayout(context, attrs);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        rlContents.setLayoutParams(params);
        this.addView(rlContents);

        rlContents.addView(mTvNumPro);
        rlContents.addView(mTvNumTotal);

        RelativeLayout.LayoutParams paramTvPro = (LayoutParams) mTvNumPro.getLayoutParams();
        paramTvPro.addRule(RelativeLayout.CENTER_HORIZONTAL);
        paramTvPro.addRule(RelativeLayout.BELOW, mTvNumTotal.getId());

        RelativeLayout.LayoutParams paramTvTotal = (LayoutParams) mTvNumTotal.getLayoutParams();
        paramTvTotal.addRule(RelativeLayout.CENTER_HORIZONTAL);

    }

    public synchronized int generateViewId(View view) {
        Random rand = new Random();
        int id;
        while (view.findViewById(id = rand.nextInt(Integer.MAX_VALUE) + 1) != null) ;
        return id;
    }
}
