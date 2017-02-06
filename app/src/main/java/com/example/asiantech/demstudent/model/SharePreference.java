package com.example.asiantech.demstudent.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 03/02/2017.
 */
public class SharePreference {
    private static final String FILE_NAME = "pref";
    public static final String FIRST_INIT = "the_first_init";

    public static final boolean getIsFirstInit(Context context) {
        return getBoolean(context, FIRST_INIT, false);
    }

    public static final void saveIsFirstInit(Context context, boolean value) {
        saveBoolean(context, FIRST_INIT, value);
    }

    private static String getString(Context context, String key, String valueDefault) {
        SharedPreferences pref = context.getSharedPreferences(FILE_NAME, 0);
        return pref.getString(key, valueDefault);
    }

    private static void saveString(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, 0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    private static boolean getBoolean(Context context, String key, boolean valueDefault) {
        SharedPreferences pref = context.getSharedPreferences(FILE_NAME, 0);
        return pref.getBoolean(key, valueDefault);
    }

    private static void saveBoolean(Context context, String key, boolean valueDefault) {
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, 0).edit();
        editor.putBoolean(key, valueDefault);
        editor.commit();
    }

    private static int getInt(Context context, String key, int valueDefault) {
        SharedPreferences pref = context.getSharedPreferences(FILE_NAME, 0);
        return pref.getInt(key, valueDefault);
    }

    private static void saveInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, 0).edit();
        editor.putInt(key, value);
        editor.commit();
    }
}
