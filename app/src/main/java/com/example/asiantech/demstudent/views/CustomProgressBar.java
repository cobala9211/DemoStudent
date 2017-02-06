package com.example.asiantech.demstudent.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.example.asiantech.demstudent.R;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 06/01/2017.
 */
public class CustomProgressBar extends View {

    private float progress;
    private float strokeWidth;
    private float backgroundStrokeWidth;
    private int mColorProgress = Color.BLACK;
    private int textColor = Color.BLUE;
    private int backgroundColor = Color.GRAY;

    private RectF rectF;
    private Paint backgroundPaint;
    private Paint foregroundPaint;

    private Paint mPaintNumberPro;
    private Paint mPaintNumberTotal;

    private int mTextSizeTotal;
    private int mTextSizePro;
    private Rect mBoundText;
    private String mNumberPro;
    private String mNumberTotal;

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        rectF = new RectF();
        mBoundText = new Rect();

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircularProgressBar, 0, 0);
        //Reading values from the XML layout
        try {
            // Value
            progress = typedArray.getFloat(R.styleable.CircularProgressBar_cpb_progress, progress);
            // StrokeWidth
            strokeWidth = typedArray.getDimension(R.styleable.CircularProgressBar_cpb_progressbar_width, strokeWidth);
            backgroundStrokeWidth = typedArray.getDimension(R.styleable.CircularProgressBar_cpb_background_progressbar_width, backgroundStrokeWidth);
            // Color
            mColorProgress = typedArray.getInt(R.styleable.CircularProgressBar_cpb_progressbar_color, mColorProgress);
            backgroundColor = typedArray.getInt(R.styleable.CircularProgressBar_cpb_background_progressbar_color, backgroundColor);
            textColor = typedArray.getInt(R.styleable.CircularProgressBar_cpb_text_color, textColor);

            // Text size
            mTextSizePro = typedArray.getInt(R.styleable.CircularProgressBar_cpb_text_size_pro, mTextSizePro);
            mTextSizeTotal = typedArray.getInt(R.styleable.CircularProgressBar_cpb_text_size_total, mTextSizeTotal);
            mNumberPro = typedArray.getString(R.styleable.CircularProgressBar_cpb_text_string_pro);
            mNumberTotal = typedArray.getString(R.styleable.CircularProgressBar_cpb_text_string_total);
        } finally {
            typedArray.recycle();
        }

        // Init Background
        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundPaint.setColor(backgroundColor);
        backgroundPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setStrokeWidth(backgroundStrokeWidth);

        // Init Foreground
        foregroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        foregroundPaint.setColor(mColorProgress);
        foregroundPaint.setStyle(Paint.Style.STROKE);
        foregroundPaint.setStrokeWidth(strokeWidth);

        // Init text number total
        mPaintNumberTotal = new Paint();
        mPaintNumberTotal.setColor(textColor);
        mPaintNumberTotal.setFakeBoldText(true);
        mPaintNumberTotal.setTextSize(mTextSizeTotal);

        // Init text number progress
        mPaintNumberPro = new Paint();
        mPaintNumberPro.setColor(textColor);
        mPaintNumberPro.setFakeBoldText(true);
        mPaintNumberPro.setTextSize(mTextSizePro);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawProgress(canvas);
        drawTextNewCenter(canvas);
    }

    /**
     * This method draw text progress
     *
     * @param canvas
     */
    private void drawTextNewCenter(Canvas canvas) {
        mPaintNumberTotal.getTextBounds(mNumberTotal, 0, mNumberTotal.length(), mBoundText);
        canvas.drawText(mNumberTotal, (float) (getWidth() / 2 - mBoundText.width() / 2),
                getHeight() / 2 + mBoundText.height() / 2 - mTextSizePro / 2 - 10, mPaintNumberTotal);
        mPaintNumberPro.getTextBounds(mNumberPro, 0, mNumberPro.length(), mBoundText);
        canvas.drawText(mNumberPro, getWidth() / 2 - mBoundText.width() / 2,
                (float) (getHeight() / 2 + mBoundText.height() / 2 + mTextSizeTotal / 2 + 5), mPaintNumberPro);
    }

    /**
     * This method draw progress
     *
     * @param canvas
     */
    private void drawProgress(Canvas canvas) {
        float angle = 360 * progress / 100;
        int startAngle = -90;
        // draw background
        canvas.drawOval(rectF, backgroundPaint);
        // draw progress
        canvas.drawArc(rectF, startAngle, angle, false, foregroundPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        final int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int min = Math.min(width, height);
        setMeasuredDimension(min, min);
        float highStroke = (strokeWidth > backgroundStrokeWidth) ? strokeWidth : backgroundStrokeWidth;
        rectF.set(0 + highStroke / 2, 0 + highStroke / 2, min - highStroke / 2, min - highStroke / 2);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = (progress <= 100) ? progress : 100;
        invalidate();
    }

    public float getProgressBarWidth() {
        return strokeWidth;
    }

    public void setProgressBarWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
        foregroundPaint.setStrokeWidth(strokeWidth);
        requestLayout();//Because it should recalculate its bounds
        invalidate();
    }

    public float getBackgroundProgressBarWidth() {
        return backgroundStrokeWidth;
    }

    public void setBackgroundProgressBarWidth(float backgroundStrokeWidth) {
        this.backgroundStrokeWidth = backgroundStrokeWidth;
        backgroundPaint.setStrokeWidth(backgroundStrokeWidth);
        requestLayout();//Because it should recalculate its bounds
        invalidate();
    }

    public int getColor() {
        return mColorProgress;
    }

    public void setColor(int color) {
        this.mColorProgress = color;
        foregroundPaint.setColor(color);
        invalidate();
        requestLayout();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        backgroundPaint.setColor(backgroundColor);
        invalidate();
        requestLayout();
    }

    public void setProgressWithAnimation(float progress) {
        setProgressWithAnimation(progress, 1500);
    }

    public void setProgressWithAnimation(float progress, int duration) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "progress", progress);
        objectAnimator.setDuration(duration);
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.start();
    }

}