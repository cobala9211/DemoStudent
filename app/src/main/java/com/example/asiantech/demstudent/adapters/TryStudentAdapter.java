package com.example.asiantech.demstudent.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.model.ItemTryStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 09/01/2017.
 */
public class TryStudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemTryStudent> mListTryStudent = new ArrayList<>();
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_BOTTOM = 1;
    private static final int TYPE_ROW = 2;

    public TryStudentAdapter(List<ItemTryStudent> list) {
        this.mListTryStudent = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewItemType;
        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_header_student, parent, false);
            viewItemType = new HolderHeader(view);
        } else if (viewType == TYPE_BOTTOM) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_bottom_student, parent, false);
            viewItemType = new HolderBottom(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_row_student, parent, false);
            viewItemType = new HolderRow(view);
        }
        return viewItemType;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            HolderHeader viewHeader = (HolderHeader) holder;
            viewHeader.tvStartTime.setText(mListTryStudent.get(position).getStartTime());
            viewHeader.tvEndTime.setText(mListTryStudent.get(position).getEndTime());
        } else if (getItemViewType(position) == TYPE_ROW) {
            HolderRow viewRow = (HolderRow) holder;
            viewRow.tvTitleVideo.setText(mListTryStudent.get(position).getTitleVideo());
            viewRow.tvTitleVideo.setTextColor(Color.parseColor(mListTryStudent.get(position).getColor()));
            viewRow.tvDurationVideo.setText(mListTryStudent.get(position).getDuration());
            viewRow.tvDescriptionVideo.setText(mListTryStudent.get(position).getDescription());
            viewRow.tvDateVideo.setText(mListTryStudent.get(position).getDate());
        }
    }

    @Override
    public int getItemCount() {
        if (null == mListTryStudent) {
            return 0;
        }
        return mListTryStudent.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 5) return TYPE_HEADER;
        if (position == 4 || position == mListTryStudent.size() - 1) return TYPE_BOTTOM;
        return TYPE_ROW;
    }

    static class HolderRow extends RecyclerView.ViewHolder {
        private TextView tvTitleVideo;
        private TextView tvDescriptionVideo;
        private TextView tvDateVideo;
        private TextView tvDurationVideo;

        public HolderRow(View itemView) {
            super(itemView);
            tvTitleVideo = (TextView) itemView.findViewById(R.id.tvTitleVideo);
            tvDescriptionVideo = (TextView) itemView.findViewById(R.id.tvDescription);
            tvDurationVideo = (TextView) itemView.findViewById(R.id.tvDurationVideo);
            tvDateVideo = (TextView) itemView.findViewById(R.id.tvVideoDate);
        }
    }

    static class HolderHeader extends RecyclerView.ViewHolder {
        private TextView tvStartTime;
        private TextView tvEndTime;

        public HolderHeader(View itemView) {
            super(itemView);
            tvStartTime = (TextView) itemView.findViewById(R.id.tvStartTime);
            tvEndTime = (TextView) itemView.findViewById(R.id.tvEndTime);
        }
    }

    static class HolderBottom extends RecyclerView.ViewHolder {

        public HolderBottom(View itemView) {
            super(itemView);
        }
    }
}
