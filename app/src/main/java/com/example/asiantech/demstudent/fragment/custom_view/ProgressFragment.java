package com.example.asiantech.demstudent.fragment.custom_view;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.fragment.BaseFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 03/02/2017.
 */
@EFragment(R.layout.fragment_progress_circle)
public class ProgressFragment extends BaseFragment {
    @ViewById(R.id.circularProgressbar)
    CircularProgressBar mCircularProgressBar;

    @Override
    protected void initView() {
        mCircularProgressBar.setProgress(50);
        mCircularProgressBar.animateProgressTo(0, 50, null);
    }
}
