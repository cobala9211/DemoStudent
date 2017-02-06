package com.example.asiantech.demstudent.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
public class ToolBarHorizontalScroll extends HorizontalScrollView {

    private List<String> mListItem = new ArrayList<>();
    private GestureDetector gestureDetector;
    private static final int SWIPE_MIN_DISTANCE = 5;
    private static final int SWIPE_THRESHOLD_VELOCITY = 300;
    private int activeFeature = 0;

    private void addTitle() {
        for (int i = 0; i < 10; i++) {
            mListItem.add("タイトル " + i);
        }
    }

    public ToolBarHorizontalScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTitle();
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setFadingEdgeLength(0);
        this.setHorizontalScrollBarEnabled(false);
        this.setVerticalScrollBarEnabled(false);
        LinearLayout internalWrapper = new LinearLayout(context);
        internalWrapper.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        internalWrapper.setOrientation(LinearLayout.HORIZONTAL);
        addView(internalWrapper);
        for (int i = 0; i < mListItem.size(); i++) {
            LinearLayout featureLayout = new LinearLayout(context, attrs);
            featureLayout.setOrientation(LinearLayout.HORIZONTAL);

            RelativeLayout rlLayout = (RelativeLayout) View.inflate(context, R.layout.item_header_horizontal, null);
            TextView tvTitle = (TextView) rlLayout.findViewById(R.id.tvTitle);
            tvTitle.setText(mListItem.get(i));
            internalWrapper.addView(rlLayout);
        }
        gestureDetector = new GestureDetector(new MyGestureDetector());
        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                    int scrollX = getScrollX();
                    int featureWidth = getMeasuredWidth();
                    activeFeature = ((scrollX + (featureWidth / 2)) / featureWidth);
                    int scrollTo = activeFeature * featureWidth;
                    smoothScrollTo(scrollTo, 0);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }


    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                //right to left
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    activeFeature = (activeFeature < (mListItem.size() - 1)) ? activeFeature + 1 : mListItem.size() - 1;
                    smoothScrollTo(activeFeature * getMeasuredWidth(), 0);
                    return true;
                }
                //left to right
                else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    activeFeature = (activeFeature > 0) ? activeFeature - 1 : 0;
                    smoothScrollTo(activeFeature * getMeasuredWidth(), 0);
                    return true;
                }
            } catch (Exception e) {
                // nothing
            }
            return false;
        }
    }
}
