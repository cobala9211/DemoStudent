package com.example.asiantech.demstudent.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.model.DbItemSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 03/02/2017.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {
    private List<DbItemSearch> mListItem = new ArrayList<>();
    private List<DbItemSearch> mListItemTemp = new ArrayList<>();

    public SearchAdapter(List<DbItemSearch> list) {
        this.mListItem = list;
        this.mListItemTemp.clear();
        this.mListItemTemp.addAll(mListItem);
    }

    @Override
    public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_search, parent, false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchHolder holder, int position) {
        SearchHolder searchHolder = holder;
        searchHolder.tvTitle.setText(mListItem.get(position).getTitle());
        if (position == 0) {
            searchHolder.tvTitle.setText("Result Search Item");
            searchHolder.imgIcon.setImageResource(R.drawable.ic_search_history);
        }
    }

    @Override
    public int getItemCount() {
        if (null == mListItem) {
            return 0;
        }
        return mListItem.size();
    }

    public void filterSearchList(String strQuery) {
        mListItem.clear();
        if (strQuery == null || strQuery.length() == 0) {
            mListItem.addAll(mListItemTemp);
            return;
        } else {
            strQuery = strQuery.toLowerCase(Locale.getDefault());
            for (int i = 0; i < mListItemTemp.size(); i++) {
                if (mListItemTemp.get(i).getTitle().toLowerCase(Locale.getDefault()).contains(strQuery)) {
                    mListItem.add(mListItemTemp.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }

    static class SearchHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final ImageView imgIcon;

        public SearchHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
        }
    }

}
