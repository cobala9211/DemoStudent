package com.example.asiantech.demstudent.fragment.video;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.adapters.VideoAdapter;
import com.example.asiantech.demstudent.dialog.MenuDialog;
import com.example.asiantech.demstudent.fragment.BaseFragment;
import com.example.asiantech.demstudent.model.ItemVideoInfo;
import com.example.asiantech.demstudent.util.ClickItemRecyclerView;
import com.example.asiantech.demstudent.util.IClickItemRecyclerView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
@EFragment(R.layout.fragment_video)
public class VideoFragment extends BaseFragment {

    @ViewById(R.id.recyclerViewVideo)
    RecyclerView mRecycleVideo;
    private VideoAdapter mAdapter;

    @Override
    protected void initView() {
        createView();
    }

    private void createView() {
        mAdapter = new VideoAdapter(createListData());
        GridLayoutManager lm = new GridLayoutManager(getContext(), 3);
        mRecycleVideo.setLayoutManager(lm);
        mRecycleVideo.setHasFixedSize(true);
        mRecycleVideo.setAdapter(mAdapter);
        lm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position == 0 || position == 6) ? 3 : 1;
            }
        });
        mRecycleVideo.addOnItemTouchListener(new ClickItemRecyclerView(getContext(), mRecycleVideo, new IClickItemRecyclerView() {
            @Override
            public void onClick(View view, int position) {
                mRecycleVideo.getChildAt(position).setEnabled(false);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private List<ItemVideoInfo> createListData() {
        boolean isVisible;
        List<ItemVideoInfo> mListItem = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            isVisible = false;
            if (i == 3 || i == 4) {
                isVisible = true;
            }
            mListItem.add(new ItemVideoInfo("主題 " + i, "年 " + i, "999/88" + i, "199/21" + i, "infoText", isVisible));
        }
        return mListItem;
    }


}
