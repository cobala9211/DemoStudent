package com.example.asiantech.demstudent.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
public class KeyBoard {
    private Context mContext;


    public KeyBoard(Context context) {
        this.mContext = context;
    }

    public void showKeyBoard(View view) {
        try {
            if (!view.hasFocus()) {
                view.requestFocus();
            }
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideKeyBoard(View view) {
        if (null != view) {
            InputMethodManager im = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
