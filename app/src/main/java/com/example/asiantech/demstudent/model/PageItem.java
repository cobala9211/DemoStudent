package com.example.asiantech.demstudent.model;

import android.support.v4.app.Fragment;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 05/01/2017.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class PageItem {
    private Fragment fragment;
    private String title;
    private int drawableResource;
}
