package com.example.asiantech.demstudent.fragment.custom_view;

import android.support.v4.view.ViewPager;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.adapters.PagerCustomAdapter;
import com.example.asiantech.demstudent.fragment.BaseFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 02/02/2017.
 */
@EFragment(R.layout.fragment_view_pager)
public class ViewPagerFragment extends BaseFragment {
    @ViewById(R.id.viewPagerCustoms)
    ViewPager mViewPager;

    @Override
    protected void initView() {
        initViewPager();
    }

    private void initViewPager() {
        mViewPager.setClipToPadding(false);
        PagerCustomAdapter adapter = new PagerCustomAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(adapter.getCount());
        mViewPager.setPageMargin(20);
        mViewPager.setAdapter(adapter);
    }
}
