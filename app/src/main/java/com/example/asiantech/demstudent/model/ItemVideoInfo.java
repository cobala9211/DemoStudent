package com.example.asiantech.demstudent.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 07/01/2017.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class ItemVideoInfo {
    private String titleSubject;
    private String titleYear;
    private String numCub;
    private String numLevel;
    private String titleInfo;
    private boolean isVisible;
}
