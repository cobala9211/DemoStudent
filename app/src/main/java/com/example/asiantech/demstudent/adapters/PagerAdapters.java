package com.example.asiantech.demstudent.adapters;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.activity.MainActivity;
import com.example.asiantech.demstudent.model.PageItem;
import com.example.asiantech.demstudent.views.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
public class PagerAdapters extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    private List<PageItem> mListPageItem = new ArrayList<>();
    private Context mContext;
    private int mNotifyCount;
    private boolean unReadNotify;

    public PagerAdapters(Context context, List<PageItem> listPageItem) {
        super(((MainActivity) context).getSupportFragmentManager());
        this.mContext = context;
        this.mListPageItem = listPageItem;
    }

    @Override
    public Fragment getItem(int position) {
        return mListPageItem.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mListPageItem.size();
    }

    @Override
    public int getPageIconResId(int position) {
        return mListPageItem.get(position).getDrawableResource();
    }

    @Override
    public View getView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_tab_item, null, false);
        TextView title = (TextView) view.findViewById(R.id.tvTitleItem);
        View imgItem = view.findViewById(R.id.imgItem);
        title.setText(mListPageItem.get(position).getTitle());
        if (Build.VERSION.SDK_INT < 23) {
            imgItem.setBackgroundDrawable(mContext.getResources().getDrawable(mListPageItem.get(position).getDrawableResource()));
        } else {
            imgItem.setBackground(mContext.getResources().getDrawable(mListPageItem.get(position).getDrawableResource()));
        }
        return view;
    }

    @Override
    public void onTabClick(int position, boolean isSameTab) {
        Log.d("TAG11", "onTabClick: true");
    }

}
