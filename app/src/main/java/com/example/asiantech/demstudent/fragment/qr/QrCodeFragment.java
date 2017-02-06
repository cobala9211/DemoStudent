package com.example.asiantech.demstudent.fragment.qr;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.activity.SearchAdapter;
import com.example.asiantech.demstudent.fragment.BaseFragment;
import com.example.asiantech.demstudent.model.DbItemSearch;
import com.example.asiantech.demstudent.model.ItemSearch;
import com.orm.query.Select;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
@EFragment(R.layout.fragment_qr_code)
public class QrCodeFragment extends BaseFragment {

    @ViewById(R.id.edtInputSearch)
    EditText mEdtInputSearch;
    @ViewById(R.id.tvTitleSearch)
    TextView mTvTitleSearch;
    @ViewById(R.id.recyclerViewSearch)
    RecyclerView mRecyclerViewSearch;
    @ViewById(R.id.imgClose)
    ImageView mImgClose;
    @ViewById(R.id.imgSearch)
    ImageView mImgSearch;

    private SearchAdapter mAdapter;

    @Override
    protected void initView() {
        initRecyclerView();
        mEdtInputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (null != mEdtInputSearch) {
                    String mInputString = mEdtInputSearch.getText().toString();
                    mAdapter.filterSearchList(mInputString);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewSearch.setLayoutManager(layoutManager);
        mRecyclerViewSearch.setHasFixedSize(true);
        mAdapter = new SearchAdapter(getListDb());
        mRecyclerViewSearch.setAdapter(mAdapter);

    }

    public List<DbItemSearch> getListDb() {
        List<DbItemSearch> listDb = DbItemSearch.listAll(DbItemSearch.class);
        return listDb;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Click(R.id.imgSearch)
    void onClickSearch() {
        mImgClose.setVisibility(View.VISIBLE);
        mEdtInputSearch.setVisibility(View.VISIBLE);
        mTvTitleSearch.setVisibility(View.GONE);
        mImgSearch.setVisibility(View.GONE);
        Log.d("TAG11", "on click search");
    }

    @Click(R.id.imgClose)
    void onClickClose() {
        mImgClose.setVisibility(View.GONE);
        mEdtInputSearch.setVisibility(View.GONE);
        mTvTitleSearch.setVisibility(View.VISIBLE);
        mImgSearch.setVisibility(View.VISIBLE);
        mAdapter.filterSearchList(null);
        Log.d("TAG11", "close onclick");
    }
}
