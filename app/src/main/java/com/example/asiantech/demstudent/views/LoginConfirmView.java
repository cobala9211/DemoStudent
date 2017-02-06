package com.example.asiantech.demstudent.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
public class LoginConfirmView extends RelativeLayout {

    IListenerKeyBoard mIListenerKeyBoard;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int realHeight = MeasureSpec.getSize(heightMeasureSpec);
        final int actualHeight = getHeight();
        if (mIListenerKeyBoard != null) {
            mIListenerKeyBoard.onResult(actualHeight > realHeight);
        }
    }

    public interface IListenerKeyBoard {
        void onResult(boolean isShow);
    }

    public LoginConfirmView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setmIListenerKeyBoard(IListenerKeyBoard keyBoard) {
        this.mIListenerKeyBoard = keyBoard;
    }
}
