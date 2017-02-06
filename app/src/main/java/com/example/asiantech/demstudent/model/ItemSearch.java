package com.example.asiantech.demstudent.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 03/02/2017.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class ItemSearch {
    private String title;
    private int urlImg;
}
