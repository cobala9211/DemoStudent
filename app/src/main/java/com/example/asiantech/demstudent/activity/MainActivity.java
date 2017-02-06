package com.example.asiantech.demstudent.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.fragment.MainFragment;
import com.example.asiantech.demstudent.fragment.MainFragment_;
import com.example.asiantech.demstudent.fragment.my_page.MyPageFragment;
import com.example.asiantech.demstudent.fragment.my_page.MyPageFragment_;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentByTag;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @FragmentByTag("MainFragment")
    MainFragment mMainFragment;

    @Override
    void initView() {
        if (null == mMainFragment) {
            mMainFragment = MainFragment_.builder().build();
            startFragment(mMainFragment, "MainFragment");
        }
    }

    private void startFragment(Fragment fragment, String titleFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, fragment, titleFragment);
        ft.commit();
    }
}
