package com.example.asiantech.demstudent.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.asiantech.demstudent.R;
import com.example.asiantech.demstudent.model.MyPageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 06/01/2017.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {
    private List<MyPageItem> mListPage = new ArrayList<>();

    public ExpandableAdapter(List<MyPageItem> list) {
        this.mListPage = list;
    }

    @Override
    public int getGroupCount() {
        return mListPage.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mListPage.get(groupPosition).getListDetail().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mListPage.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListPage.get(groupPosition).getListDetail().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_list_expan_header, parent, false);
        }

        TextView tvHeader = (TextView) convertView.findViewById(R.id.tvHeader);
        tvHeader.setText(((MyPageItem) getGroup(groupPosition)).getTitleSubject());
        TextView tvNumCub = (TextView) convertView.findViewById(R.id.tvNumCub);
        tvNumCub.setText(((MyPageItem) getGroup(groupPosition)).getCountCub());
        TextView tvNumLevel = (TextView) convertView.findViewById(R.id.tvNumCheck);
        tvNumLevel.setText(((MyPageItem) getGroup(groupPosition)).getCountCheck());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String expandableListText = ((MyPageItem.detailSubject) getChild(groupPosition, childPosition)).getNameSubject();
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_list_expan_view, parent, false);
        }
        TextView tvTitleView = (TextView) convertView.findViewById(R.id.tvViewTitle);
        tvTitleView.setText(expandableListText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}