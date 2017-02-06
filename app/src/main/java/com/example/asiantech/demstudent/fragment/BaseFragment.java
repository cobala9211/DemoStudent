package com.example.asiantech.demstudent.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 04/01/2017.
 */
@EFragment
public abstract class BaseFragment extends Fragment {
    @AfterViews
    protected abstract void initView();

    public void addChildFragment(Fragment fragment) {
        if (getParentFragment() != null && getParentFragment() instanceof BaseFragment) {
            ((BaseFragment) getParentFragment()).addChildFragmentNotAnimation(fragment);
        }
        if (checkViewID(getView())) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(getView().getId(), fragment, fragment.getClass().getSimpleName());
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    private boolean checkViewID(View view) {
        if (view == null || view.getId() < 0) {
            return false;
        }
        return true;
    }

    private void addChildFragmentNotAnimation(Fragment fragment) {
        if (getParentFragment() != null && getParentFragment() instanceof BaseFragment) {
            ((BaseFragment) getParentFragment()).addChildFragmentNotAnimation(fragment);
        }
        if (checkViewID(getView())) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(getView().getId(), fragment, fragment.getClass().getSimpleName());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
