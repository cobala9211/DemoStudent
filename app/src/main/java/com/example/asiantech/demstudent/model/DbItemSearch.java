package com.example.asiantech.demstudent.model;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 03/02/2017.
 */
@Table(name = "DBSearch")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
public class DbItemSearch extends SugarRecord {

    @Column(name = "title", notNull = true)
    private String title;
    @Column(name = "img_icon")
    private int imgIcon;

    public DbItemSearch() {

    }
}
