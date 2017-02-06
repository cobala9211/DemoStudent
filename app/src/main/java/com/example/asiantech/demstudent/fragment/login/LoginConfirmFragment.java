package com.example.asiantech.demstudent.fragment.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.activity.MainActivity;
import com.example.asiantech.demstudent.activity.MainActivity_;
import com.example.asiantech.demstudent.fragment.BaseFragment;
import com.example.asiantech.demstudent.util.KeyBoard;
import com.example.asiantech.demstudent.views.LoginConfirmView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
@EFragment(R.layout.fragment_confirm_login)
public class LoginConfirmFragment extends BaseFragment implements EditText.OnEditorActionListener {
    private onClickBack mOnClickBack;
    @ViewById(R.id.edtEmail)
    EditText mEdtEmail;
    @ViewById(R.id.edtPassword)
    EditText mEdtPassword;
    @ViewById(R.id.btnLogin)
    TextView mBtnLogin;
    @ViewById(R.id.rlLayout)
    LoginConfirmView mRlLayout;

    private KeyBoard mKeyBoard;

    @Override
    protected void initView() {
        mKeyBoard = new KeyBoard(getContext());
        mEdtEmail.setOnEditorActionListener(this);
        mEdtPassword.setOnEditorActionListener(this);

        mRlLayout.setmIListenerKeyBoard(new LoginConfirmView.IListenerKeyBoard() {
            @Override
            public void onResult(boolean isShow) {
                if (isShow) {
                    Log.d("TAG11", "action isShow keyBoard");
                }
            }
        });
    }

    public void initOnClickBack(onClickBack click) {
        this.mOnClickBack = click;
    }

    @Click({R.id.btnLogin, R.id.imgBack, R.id.tvTitleBack, R.id.edtEmail, R.id.edtPassword})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                checkLogin(mEdtEmail.getText().toString(), mEdtPassword.getText().toString());
                break;
            case R.id.imgBack:
            case R.id.tvTitleBack:
                if (null != mOnClickBack) {
                    mOnClickBack.onClickButtonBack(view);
                    mKeyBoard.hideKeyBoard(view);
                }
                break;
            case R.id.edtEmail:
                mKeyBoard.showKeyBoard(mEdtEmail);
                break;
            case R.id.edtPassword:
                mKeyBoard.showKeyBoard(mEdtPassword);
                break;
            default:
                throw new IllegalStateException("not found id view");
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean handled = false;
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            if (mEdtEmail.getText().toString().equals("123")) {
                Log.d("TAG11", "action 12345");
                mBtnLogin.setText("ログインID");
                setStyleView(getContext(), R.style.button_login_confirm_error, mBtnLogin, R.drawable.custom_button_confirm_error);
            } else {
                mBtnLogin.setText("ログイン");
                setStyleView(getContext(), R.style.button_login_confirm, mBtnLogin, R.drawable.custom_button_confirm_login);
            }
            handled = true;
        }
        return handled;
    }

    private void setStyleView(Context context, int id, TextView view, int idDraw) {
        if (Build.VERSION.SDK_INT < 23) {
            view.setTextAppearance(context, id);
            view.setBackgroundDrawable(getResources().getDrawable(idDraw));
        } else {
            view.setTextAppearance(id);
            view.setBackground(getResources().getDrawable(idDraw));
        }
    }

    public interface onClickBack {
        void onClickButtonBack(View view);
    }

    private void checkLogin(String email, String password) {
        if (email.equals("abc") && password.equals("123")) {
            Log.d("TAG11", "checkLogin: true");
        } else {
            mKeyBoard.hideKeyBoard(getView());
            MainActivity_.intent(getActivity()).start();
            getActivity().finish();
        }
    }

}
