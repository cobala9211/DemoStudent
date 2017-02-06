package com.example.asiantech.demstudent.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.fragment.custom_view.ProgressFragment;
import com.example.asiantech.demstudent.fragment.custom_view.ProgressFragment_;
import com.example.asiantech.demstudent.fragment.custom_view.RegisterFragment;
import com.example.asiantech.demstudent.fragment.custom_view.RegisterFragment_;
import com.example.asiantech.demstudent.fragment.custom_view.ViewPagerFragment;
import com.example.asiantech.demstudent.fragment.custom_view.ViewPagerFragment_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentByTag;
import org.androidannotations.annotations.ViewById;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 03/02/2017.
 */
@EActivity(R.layout.activity_student_view)
public class StudentViewActivity extends BaseActivity {
    @FragmentByTag("RegisterFragment")
    RegisterFragment mRegisterFragment;
    @FragmentByTag("ViewPagerFragment")
    ViewPagerFragment mViewPagerFragment;
    @FragmentByTag("CustomFragment")
    ProgressFragment mProgressFragment;
    @ViewById(R.id.llControls)
    LinearLayout mLlControl;

    @Override
    void initView() {

    }

    @Click({R.id.btnDemoViewPager1, R.id.btnDemoViewPager2, R.id.btnDemoProgress})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDemoViewPager1:
                mLlControl.setVisibility(View.GONE);
                if (null == mRegisterFragment) {
                    mRegisterFragment = RegisterFragment_.builder().build();
                }
                startFragmentToStack(mRegisterFragment, "RegisterFragment");
                break;
            case R.id.btnDemoViewPager2:
                mLlControl.setVisibility(View.GONE);
                if (null == mViewPagerFragment) {
                    mViewPagerFragment = ViewPagerFragment_.builder().build();
                }
                startFragmentToStack(mViewPagerFragment, "ViewPagerFragment");
                break;
            case R.id.btnDemoProgress:
                mLlControl.setVisibility(View.GONE);
                if (null == mProgressFragment) {
                    mProgressFragment = ProgressFragment_.builder().build();
                }
                startFragmentToStack(mProgressFragment, "ProgressFragment");
                break;
            default:
                throw new IllegalStateException("not found id of view");
        }
    }

    private void startFragmentToStack(Fragment fragment, String title) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutView, fragment, title);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }
}
