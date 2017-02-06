package com.example.asiantech.demstudent.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 06/01/2017.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class MyPageItem {
    private String color;
    private String titleSubject;
    private String detailSubject;
    private String countCub;
    private String countCheck;
    private List<detailSubject> listDetail;

    @Data
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class detailSubject {
        private String nameSubject;
        private String numberRise;
        private String numPersen;
    }
}
