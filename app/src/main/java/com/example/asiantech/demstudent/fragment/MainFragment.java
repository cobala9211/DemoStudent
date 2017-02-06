package com.example.asiantech.demstudent.fragment;

import android.support.v4.view.ViewPager;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.adapters.PagerAdapters;
import com.example.asiantech.demstudent.fragment.my_page.MyPageFragment_;
import com.example.asiantech.demstudent.fragment.qr.QrCodeFragment_;
import com.example.asiantech.demstudent.fragment.setting.SettingFragment_;
import com.example.asiantech.demstudent.fragment.try_student.TryStudentFragment_;
import com.example.asiantech.demstudent.fragment.video.VideoFragment_;
import com.example.asiantech.demstudent.model.PageItem;
import com.example.asiantech.demstudent.views.NonSwipeViewPager;
import com.example.asiantech.demstudent.views.PagerSlidingTabStrip;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    public static final int TAB_COUNT = 5;
    public static final int POSITION_MY_PAGE = 1;
    public static final int POSITION_VIDEO = 2;
    public static final int POSITION_TRY_STUDENT = 3;
    public static final int POSITION_QR_CODE = 4;
    public static final int POSITION_SETTING = 5;
    @ViewById(R.id.tabStripMain)
    PagerSlidingTabStrip mPagerTabStrip;
    @ViewById(R.id.viewPagerMain)
    NonSwipeViewPager mSwipeViewPager;

    @Override
    protected void initView() {
        initViewPager();
    }

    private void initViewPager() {
        List<PageItem> listItemPage = new ArrayList<>();
        listItemPage.add(new PageItem(MyPageFragment_.builder().build(), "MyPage", R.drawable.custom_tab_trip));
        listItemPage.add(new PageItem(VideoFragment_.builder().build(), "Video", R.drawable.custom_tab_trip));
        listItemPage.add(new PageItem(TryStudentFragment_.builder().build(), "TryStudent", R.drawable.custom_tab_trip));
        listItemPage.add(new PageItem(QrCodeFragment_.builder().build(), "QrCode", R.drawable.custom_tab_trip));
        listItemPage.add(new PageItem(SettingFragment_.builder().build(), "Setting", R.drawable.custom_tab_trip));

        PagerAdapters adapter = new PagerAdapters(getContext(), listItemPage);
        mSwipeViewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mSwipeViewPager.setCurrentItem(0, false);
        mSwipeViewPager.setOffscreenPageLimit(5);
        mPagerTabStrip.setViewPager(mSwipeViewPager);
        mPagerTabStrip.setDividerColor(0x30FFFFFF);
        mPagerTabStrip.setIndicatorColor(0x0033b5e5);
        mPagerTabStrip.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
