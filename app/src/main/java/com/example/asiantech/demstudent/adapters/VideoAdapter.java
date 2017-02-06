package com.example.asiantech.demstudent.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.model.ItemVideoInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 07/01/2017.
 */
public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ItemVideoInfo> mListVideo = new ArrayList<>();
    private static final int TYPE_HEADER = 1;
    private static final int TYPE_ROW = 2;
    private static final int TYPE_ROW_DISABLE = 3;
    private String mTitleHome = "質問中";
    private String mTitleConfirm = "返信あり";

    public VideoAdapter(List<ItemVideoInfo> list) {
        mListVideo = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_video_header, parent, false);
            viewHolder = new HolderHeader(view);
        } else if (viewType == TYPE_ROW_DISABLE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lsit_video_disable, parent, false);
            viewHolder = new HolderRowDisable(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_video, parent, false);
            viewHolder = new HolderRow(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            HolderHeader viewHeader = (HolderHeader) holder;
            viewHeader.tvTitleBook.setText(mTitleHome);
            viewHeader.tvTitleConfirm.setText(mTitleConfirm);
        }
        if (getItemViewType(position) == TYPE_ROW) {
            HolderRow viewRow = (HolderRow) holder;
            viewRow.tvTitleNumCub.setText(mListVideo.get(position).getNumCub());
            viewRow.tvTitleNumLevel.setText(mListVideo.get(position).getNumLevel());
            viewRow.tvTitleSubject.setText(mListVideo.get(position).getTitleSubject());
            viewRow.tvTitleYear.setText(mListVideo.get(position).getTitleYear());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 6) {
            return TYPE_HEADER;
        } else if (position == 3 || position == 4) {
            return TYPE_ROW_DISABLE;
        } else {
            return TYPE_ROW;
        }
    }


    @Override
    public int getItemCount() {
        if (null == mListVideo) {
            return 0;
        }
        return mListVideo.size();
    }

    class HolderRow extends RecyclerView.ViewHolder {

        private TextView tvTitleSubject;
        private TextView tvTitleYear;
        private TextView tvTitleNumCub;
        private TextView tvTitleNumLevel;

        public HolderRow(View itemView) {
            super(itemView);
            tvTitleSubject = (TextView) itemView.findViewById(R.id.tvTitleSubject);
            tvTitleYear = (TextView) itemView.findViewById(R.id.tvSubjectYear);
            tvTitleNumCub = (TextView) itemView.findViewById(R.id.tvNumCub);
            tvTitleNumLevel = (TextView) itemView.findViewById(R.id.tvNumCheck);
        }
    }

    class HolderHeader extends RecyclerView.ViewHolder {
        private TextView tvTitleBook;
        private TextView tvTitleConfirm;

        public HolderHeader(View itemView) {
            super(itemView);
            tvTitleBook = (TextView) itemView.findViewById(R.id.tvTitleHome);
            tvTitleConfirm = (TextView) itemView.findViewById(R.id.tvTitleConfirm);
        }
    }

    class HolderRowDisable extends RecyclerView.ViewHolder {

        public HolderRowDisable(View itemView) {
            super(itemView);
        }
    }

}
