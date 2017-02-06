package com.example.asiantech.demstudent.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.asiantech.demstudent.R;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 06/01/2017.
 */
public class customProgressHorizontal extends View {

    private Paint mPaintProgress;
    private Paint mPaintBackground;
    private int mColorProgress;
    private int mProgressMax;
    private int mWidth;
    private int mHeight;
    private int mStartX;
    private int mStartY;

    public customProgressHorizontal(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.customProgressHorizontal, 0, 0);
        try {
            mWidth = typedArray.getInt(R.styleable.customProgressHorizontal_cpdh_progress_width, mWidth);
            mHeight = typedArray.getInt(R.styleable.customProgressHorizontal_cpdh_progress_height, mHeight);
            mProgressMax = typedArray.getInt(R.styleable.customProgressHorizontal_cpdh_progress_max, mProgressMax);
            mColorProgress = typedArray.getInt(R.styleable.customProgressHorizontal_cpdh_progress_color, mColorProgress);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            typedArray.recycle();
        }
        if (null == mPaintBackground) {
            mPaintBackground = new Paint();
            mPaintBackground.setStyle(Paint.Style.STROKE);
            mPaintBackground.setColor(mColorProgress);
        }
        if (null == mPaintProgress) {
            mPaintProgress = new Paint();
            mPaintProgress.setColor(mColorProgress);
            mPaintProgress.setStyle(Paint.Style.FILL);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mHeight, mHeight, mWidth, 2 * mHeight, mPaintBackground);
        canvas.drawRect(mHeight, mHeight, mHeight + mCount, 2 * mHeight, mPaintProgress);
        invalidate();
    }

    private static final long DELAY_TIME_MILLIS = 100L;
    // check status update view
    public boolean mIsUpdateView = false;
    private UpdateViewRunnable updateViewRunnable = new UpdateViewRunnable();
    // count of thumb when touch or not
    private float mCount = 0;
    private boolean isProgress = false;

    private class UpdateViewRunnable implements Runnable {

        @Override
        public void run() {
            mIsUpdateView = true;
            isProgress = true;
            if (isProgress) {
                mCount = mCount + 10;
            }
            if (mIsUpdateView) {
                postDelayed(this, DELAY_TIME_MILLIS);
            }
            if (mCount > mProgressMax) {
                setIsUpdateView(false);
                isProgress = false;
                mCount = mProgressMax;
            }
        }
    }

    private void setIsUpdateView(boolean isUpdate) {
        this.mIsUpdateView = isUpdate;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setIsUpdateView(true);
        postDelayed(updateViewRunnable, DELAY_TIME_MILLIS);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setIsUpdateView(false);
    }

}
