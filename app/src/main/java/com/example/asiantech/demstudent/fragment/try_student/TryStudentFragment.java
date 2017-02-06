package com.example.asiantech.demstudent.fragment.try_student;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.adapters.TryStudentAdapter;
import com.example.asiantech.demstudent.dialog.MenuDialog;
import com.example.asiantech.demstudent.fragment.BaseFragment;
import com.example.asiantech.demstudent.model.ItemTryStudent;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
@EFragment(R.layout.fragment_try_student)
public class TryStudentFragment extends BaseFragment {
    @ViewById(R.id.recyclerViewVideo)
    RecyclerView mRecyclerView;
    private TryStudentAdapter mAdapter;
    private MenuDialog menuDialog;

    protected void initView() {
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setHasFixedSize(true);
        if (null == getListData()) {
            return;
        } else {
            mAdapter = new TryStudentAdapter(getListData());
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private List<ItemTryStudent> getListData() {
        List<ItemTryStudent> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ItemTryStudent("タイトルビデオ", "url " + i, "説明 " + i,
                    "日 : 2016/10/1" + i, "10:0" + i, getColorRandom(), "2016/10/1" + i + " 開始", "2016/12/0" + i + " 終わり"));
        }
        return list;
    }

    private String getColorRandom() {
        Random randomInt = new Random();
        int number = randomInt.nextInt(4);
        switch (number) {
            case 1:
                return "#7fc839";
            case 2:
                return "#be39c6";
            case 3:
                return "#fb9c08";
            case 4:
                return "#fc5356";
            default:
                return "#3e9aff";
        }
    }

    @Click(R.id.btnShowButton)
    void onClick(View view) {
        if (view.getId() == R.id.btnShowButton) {
            initViewDialog();
            Log.d("TAG11", "onClick: show dialog");
        }
    }

    private void initViewDialog() {
        menuDialog = new MenuDialog(getActivity());
        Window window = menuDialog.getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        wl.flags &= ~WindowManager.LayoutParams.MATCH_PARENT;
        wl.y = 0;
        window.setAttributes(wl);
        menuDialog.show();
    }

}
