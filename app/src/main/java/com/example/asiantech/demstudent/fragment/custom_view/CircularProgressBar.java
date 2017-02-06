package com.example.asiantech.demstudent.fragment.custom_view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

import com.example.asiantech.demstudent.R;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 03/02/2017.
 */
public class CircularProgressBar extends ProgressBar {
    private String mTitle;
    private String mSubTitle;

    private int mStrokeWidth;

    private final RectF mCircleBounds = new RectF();

    private final Paint mProgressColorPaint = new Paint();
    private final Paint mBackgroundColorPaint = new Paint();
    private final Paint mTitlePaint = new Paint();
    private final Paint mSubtitlePaint = new Paint();

    private boolean mHasShadow = false;
    private int mShadowColor = Color.BLACK;

    public interface ProgressAnimationListener {
        void onAnimationStart();

        void onAnimationFinish();

        void onAnimationProgress(int progress);
    }

    public CircularProgressBar(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    public void init(Context context, AttributeSet attrs, int style) {
        //so that shadow shows up properly for lines and arcs
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        TypedArray arr = getContext().obtainStyledAttributes(attrs,
                R.styleable.CircularProgressBarNew, style, 0);

        this.mHasShadow = arr.getBoolean(R.styleable.CircularProgressBarNew_cpbn_hasShadow, true);

        String color = arr.getString(R.styleable.CircularProgressBarNew_cpbn_progressColor);
        if (color == null) {
            mProgressColorPaint.setColor(ContextCompat.getColor(context, R.color.circular_progress_default_progress));
        } else {
            mProgressColorPaint.setColor(Color.parseColor(color));
        }
        color = arr.getString(R.styleable.CircularProgressBarNew_cpbn_backgroundColor);
        if (color == null) {
            mBackgroundColorPaint.setColor(ContextCompat.getColor(context, R.color.circular_progress_default_background));
        } else {
            mBackgroundColorPaint.setColor(Color.parseColor(color));
        }
        color = arr.getString(R.styleable.CircularProgressBarNew_cpbn_titleColor);
        if (color == null) {
            mTitlePaint.setColor(ContextCompat.getColor(context, R.color.circular_progress_default_title));
        } else {
            mTitlePaint.setColor(Color.parseColor(color));
        }
        color = arr.getString(R.styleable.CircularProgressBarNew_cpbn_subtitleColor);
        if (color == null) {
            mSubtitlePaint.setColor(ContextCompat.getColor(context, R.color.circular_progress_default_subtitle));
        } else {
            mSubtitlePaint.setColor(Color.parseColor(color));
        }
        String titleTemp = arr.getString(R.styleable.CircularProgressBarNew_cpbn_title);
        if (titleTemp != null) mTitle = titleTemp;
        titleTemp = arr.getString(R.styleable.CircularProgressBarNew_cpbn_subtitle);
        if (titleTemp != null) mSubTitle = titleTemp;

        mStrokeWidth = arr.getInt(R.styleable.CircularProgressBarNew_cpbn_strokeWidth, mStrokeWidth);
        arr.recycle();

        mProgressColorPaint.setAntiAlias(true);
        mProgressColorPaint.setStyle(Paint.Style.STROKE);
        mProgressColorPaint.setStrokeWidth(mStrokeWidth);

        mBackgroundColorPaint.setAntiAlias(true);
        mBackgroundColorPaint.setStyle(Paint.Style.STROKE);
        mBackgroundColorPaint.setStrokeWidth(mStrokeWidth);

        mTitlePaint.setTextSize(80);
        mTitlePaint.setStyle(Paint.Style.FILL);
        mTitlePaint.setAntiAlias(true);
        mTitlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        mTitlePaint.setShadowLayer(0.1f, 0, 1, Color.GRAY);

        mSubtitlePaint.setTextSize(30);
        mSubtitlePaint.setStyle(Paint.Style.FILL);
        mSubtitlePaint.setAntiAlias(true);
        mSubtitlePaint.setShadowLayer(0.1f, 0, 1, Color.GRAY);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(mCircleBounds, 0, 360, false, mBackgroundColorPaint);

        int progress = getProgress();
        float scale = getMax() > 0 ? (float) progress / getMax() * 360 : 0;

        if (mHasShadow)
            mProgressColorPaint.setShadowLayer(3, 0, 1, mShadowColor);
        canvas.drawArc(mCircleBounds, 270, scale, false, mProgressColorPaint);


        if (!TextUtils.isEmpty(mTitle)) {
            int xPos = (int) (getMeasuredWidth() / 2 - mTitlePaint.measureText(mTitle) / 2);
            int yPos = getMeasuredHeight() / 2;

            float titleHeight = Math.abs(mTitlePaint.descent() + mTitlePaint.ascent());
            if (TextUtils.isEmpty(mSubTitle)) {
                yPos += titleHeight / 2;
            }
            canvas.drawText(mTitle, xPos, yPos, mTitlePaint);

            yPos += titleHeight;
            xPos = (int) (getMeasuredWidth() / 2 - mSubtitlePaint.measureText(mSubTitle) / 2);

            canvas.drawText(mSubTitle, xPos, yPos, mSubtitlePaint);
        }
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        final int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int min = Math.min(width, height);
        setMeasuredDimension(min + (2 * mStrokeWidth), min + 2 * mStrokeWidth);
        mCircleBounds.set(mStrokeWidth, mStrokeWidth, min + mStrokeWidth, min + mStrokeWidth);
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);

        // the setProgress super will not change the details of the progress bar
        // anymore so we need to force an update to redraw the progress bar
        invalidate();
    }

    public void animateProgressTo(final int start, final int end, final ProgressAnimationListener listener) {
        if (start != 0)
            setProgress(start);

        final ObjectAnimator progressBarAnimator = ObjectAnimator.ofFloat(this, "animateProgress", start, end);
        progressBarAnimator.setDuration(1500);
        //		progressBarAnimator.setInterpolator(new AnticipateOvershootInterpolator(2f, 1.5f));
        progressBarAnimator.setInterpolator(new LinearInterpolator());

        progressBarAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationCancel(final Animator animation) {
            }

            @Override
            public void onAnimationEnd(final Animator animation) {
                CircularProgressBar.this.setProgress(end);
                if (listener != null)
                    listener.onAnimationFinish();
            }

            @Override
            public void onAnimationRepeat(final Animator animation) {
            }

            @Override
            public void onAnimationStart(final Animator animation) {
                if (listener != null)
                    listener.onAnimationStart();
            }
        });

        progressBarAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(final ValueAnimator animation) {
                int progress = ((Float) animation.getAnimatedValue()).intValue();
                if (progress != CircularProgressBar.this.getProgress()) {
                    CircularProgressBar.this.setProgress(progress);
                    if (listener != null)
                        listener.onAnimationProgress(progress);
                }
            }
        });
        progressBarAnimator.start();
    }

    public synchronized void setTitle(String title) {
        this.mTitle = title;
        invalidate();
    }

    public synchronized void setSubTitle(String subtitle) {
        this.mSubTitle = subtitle;
        invalidate();
    }

    public synchronized void setSubTitleColor(int color) {
        mSubtitlePaint.setColor(color);
        invalidate();
    }

    public synchronized void setTitleColor(int color) {
        mTitlePaint.setColor(color);
        invalidate();
    }

    public synchronized void setHasShadow(boolean flag) {
        this.mHasShadow = flag;
        invalidate();
    }

    public synchronized void setShadow(int color) {
        this.mShadowColor = color;
        invalidate();
    }

    public String getTitle() {
        return mTitle;
    }

    public boolean getHasShadow() {
        return mHasShadow;
    }
}