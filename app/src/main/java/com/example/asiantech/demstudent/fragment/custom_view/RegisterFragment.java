package com.example.asiantech.demstudent.fragment.custom_view;

import android.support.v4.view.ViewPager;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.adapters.RegisterPagerAdapter;
import com.example.asiantech.demstudent.fragment.BaseFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 02/02/2017.
 */
@EFragment(R.layout.fragment_register)
public class RegisterFragment extends BaseFragment {

    @ViewById(R.id.viewPagerCustom)
    PagerContainer mPagerContainer;

    @Override
    protected void initView() {
        initViewPager();
    }

    private void initViewPager() {
        ViewPager viewPager = mPagerContainer.getViewPager();
        RegisterPagerAdapter adapter = new RegisterPagerAdapter(getContext());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.setPageMargin(15);
        viewPager.setClipChildren(false);
    }
}
