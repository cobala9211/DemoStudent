package com.example.asiantech.demstudent.fragment.login;

import android.view.View;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.fragment.BaseFragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 04/01/2017.
 */
@EFragment(R.layout.fragment_login)
public class LoginFragment extends BaseFragment {
    private onClickAction mOnClickAction;

    public void initOnclick(onClickAction clickAction) {
        this.mOnClickAction = clickAction;
    }

    @Override
    protected void initView() {

    }

    @Click({R.id.btnLogin, R.id.btnRegister})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                if (null != mOnClickAction) {
                    mOnClickAction.onClickLogin(view);
                }
                break;
            case R.id.btnRegister:
                if (null != mOnClickAction) {
                    mOnClickAction.onClickRegister(view);
                }
                break;
            default:
                break;
        }
    }

    public interface onClickAction {
        void onClickLogin(View view);

        void onClickRegister(View view);
    }
}
