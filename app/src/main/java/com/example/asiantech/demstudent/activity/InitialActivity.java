package com.example.asiantech.demstudent.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.fragment.SplashFragment;
import com.example.asiantech.demstudent.fragment.SplashFragment_;
import com.example.asiantech.demstudent.fragment.login.LoginConfirmFragment;
import com.example.asiantech.demstudent.fragment.login.LoginConfirmFragment_;
import com.example.asiantech.demstudent.fragment.login.LoginFragment;
import com.example.asiantech.demstudent.fragment.login.LoginFragment_;
import com.example.asiantech.demstudent.model.DbItemSearch;
import com.example.asiantech.demstudent.model.SharePreference;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentByTag;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 04/01/2017.
 */
@EActivity(R.layout.activity_init)
public class InitialActivity extends BaseActivity implements LoginFragment.onClickAction, LoginConfirmFragment.onClickBack {
    public static final String INTENT_ACTION_FROM_NOTIFICATION = InitialActivity.class.getName() + ".from_notification";
    @FragmentByTag("SplashFragment")
    SplashFragment mSplashFragment;
    @FragmentByTag("LoginFragment")
    LoginFragment mLoginFragment;
    @FragmentByTag("LoginConfirmFragment")
    LoginConfirmFragment mLoginConfirmFragment;

    private boolean isFirstInit;

    @Override
    void initView() {
        if (null == mSplashFragment) {
            mSplashFragment = SplashFragment_.builder().build();

            startFragment(mSplashFragment, "SplashFragment");
        }
        if (null == mLoginFragment) {
            mLoginFragment = LoginFragment_.builder().build();
            startFragment(mLoginFragment, "LoginFragment");
            mLoginFragment.initOnclick(this);
        }

        //check init data sugar the first
        isFirstInit = SharePreference.getIsFirstInit(this);
        createIsFirstData();
    }

    private void createIsFirstData() {
        if (!isFirstInit) {
            isFirstInit = true;
            SharePreference.saveIsFirstInit(this, isFirstInit);
            addItemToDB();
            Log.d("TAG11", "createIsFirstData: +++");
        }
    }

    private void addItemToDB() {
        DbItemSearch db1 = new DbItemSearch("nguyen a", 1);
        db1.save();
        DbItemSearch db2 = new DbItemSearch("tran b", 1);
        db2.save();
        DbItemSearch db3 = new DbItemSearch("pham c", 1);
        db3.save();
        DbItemSearch db4 = new DbItemSearch("ngoc anh", 1);
        db4.save();
        DbItemSearch db5 = new DbItemSearch("tran xuan", 1);
        db5.save();
        DbItemSearch db6 = new DbItemSearch("phan hung", 1);
        db6.save();
        DbItemSearch db7 = new DbItemSearch("tran xuan", 1);
        db7.save();
        DbItemSearch db8 = new DbItemSearch("nguyen hung", 1);
        db8.save();
        DbItemSearch db9 = new DbItemSearch("nguyen b", 1);
        db9.save();
        DbItemSearch db10 = new DbItemSearch("tien nguyen", 1);
        db10.save();
    }

    private void startFragment(Fragment fragment, String titleFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, fragment, titleFragment);
        ft.commit();
    }

    private void startFragmentToStack(Fragment fragment, String titleFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, fragment, titleFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(titleFragment);
        ft.commit();
    }

    private Intent newIntent(Context context, boolean fromNotification) {
        Intent intent = new Intent(context, InitialActivity_.class);
        if (fromNotification) {
            intent.setAction(INTENT_ACTION_FROM_NOTIFICATION);
        }
        return intent;
    }

    @Override
    public void onClickLogin(View view) {
        mLoginConfirmFragment = LoginConfirmFragment_.builder().build();
        startFragmentToStack(mLoginConfirmFragment, "LoginConfirmFragment");
        mLoginConfirmFragment.initOnClickBack(this);
    }

    @Override
    public void onClickRegister(View view) {
        StudentViewActivity_.intent(this).start();
    }

    @Override
    public void onClickButtonBack(View view) {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getSupportFragmentManager().popBackStack();
            removeCurrentFragment();
        }
    }

    public void removeCurrentFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment currentFrag = getSupportFragmentManager().findFragmentByTag("LoginConfirmFragment");

        String fragName = "NONE";

        if (currentFrag != null)
            fragName = currentFrag.getClass().getSimpleName();

        if (currentFrag != null)
            transaction.remove(currentFrag);

        transaction.commit();

    }

}
