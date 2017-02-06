package com.example.asiantech.demstudent.fragment.my_page;

import android.widget.ExpandableListView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.adapters.ExpandableAdapter;
import com.example.asiantech.demstudent.fragment.BaseFragment;
import com.example.asiantech.demstudent.model.MyPageItem;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 04/01/2017.
 */
@EFragment(R.layout.fragment_my_page)
public class MyPageFragment extends BaseFragment {
    private ExpandableAdapter mAdapter;
    @ViewById(R.id.expandableMain)
    ExpandableListView mExpandableMyPage;

    @Override
    protected void initView() {
        initListExpandable();
    }

    private void initListExpandable() {
        mAdapter = new ExpandableAdapter(getListData());
        mExpandableMyPage.setAdapter(mAdapter);
    }

    public List<MyPageItem> getListData() {
        List<MyPageItem> listData = new ArrayList<>();

        List<MyPageItem.detailSubject> listMath = new ArrayList<>();
        listMath.add(new MyPageItem.detailSubject("Math 1", "111", "80"));
        listMath.add(new MyPageItem.detailSubject("Math 2", "222", "30"));
        listMath.add(new MyPageItem.detailSubject("Math 3", "333", "50"));
        listData.add(new MyPageItem("#3e9aff", "Math", "Math123", "12/20", "14/30", listMath));

        List<MyPageItem.detailSubject> listEnglish = new ArrayList<>();
        listEnglish.add(new MyPageItem.detailSubject("English 1", "111", "80"));
        listEnglish.add(new MyPageItem.detailSubject("English 2", "222", "30"));
        listEnglish.add(new MyPageItem.detailSubject("English 3", "333", "50"));
        listData.add(new MyPageItem("#fc5356", "English", "English123", "25/40", "20/30", listEnglish));

        List<MyPageItem.detailSubject> listHistory = new ArrayList<>();
        listHistory.add(new MyPageItem.detailSubject("History 1", "111", "80"));
        listHistory.add(new MyPageItem.detailSubject("History 2", "222", "30"));
        listHistory.add(new MyPageItem.detailSubject("History 3", "333", "50"));
        listData.add(new MyPageItem("#7fc839", "History", "History123", "10/20", "16/30", listHistory));
        return listData;
    }
}
