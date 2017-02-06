package com.example.asiantech.demstudent.fragment.setting;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.fragment.BaseFragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
@EFragment(R.layout.fragment_setting)
public class SettingFragment extends BaseFragment {

    @ViewById(R.id.viewSettingSchool)
    View mViewSettingSchool;
    @ViewById(R.id.viewSettingProblems)
    View mViewSettingProblems;
    @ViewById(R.id.viewSettingTerm)
    View mViewSettingTerm;
    @ViewById(R.id.viewLogout)
    View mViewLogout;

    @Override
    protected void initView() {
        setTextView();
    }

    private void setTextView() {
        ((TextView) mViewSettingSchool.findViewById(R.id.tvTitleItem)).setText("教科書設定の保存");
        ((TextView) mViewSettingProblems.findViewById(R.id.tvTitleItem)).setText("授業テキストの購入");
        ((TextView) mViewSettingTerm.findViewById(R.id.tvTitleItem)).setText("利用規約及びプライバシーポリシー");
        ((TextView) mViewLogout.findViewById(R.id.tvTitleItem)).setText("ログアウト");
    }

    @Click({R.id.viewSettingSchool, R.id.viewSettingProblems, R.id.viewSettingTerm, R.id.viewLogout})
    void onClickItem(View view) {
        switch (view.getId()) {
            case R.id.viewSettingSchool:
                Log.d("TAG11", "onClickItem: setting school fragment");
                addChildFragment(SettingSchoolFragment_.builder().build());
                break;
            case R.id.viewSettingProblems:
                break;
            case R.id.viewSettingTerm:
                break;
            case R.id.viewLogout:
                break;
            default:
                throw new IllegalStateException("not found view id");
        }
    }
}
