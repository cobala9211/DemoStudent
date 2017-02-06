package com.example.asiantech.demstudent.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 09/01/2017.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class ItemTryStudent {
    private String titleVideo;
    private String urlVideo;
    private String description;
    private String date;
    private String duration;
    private String color;
    private String startTime;
    private String endTime;
}
