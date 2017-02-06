package com.example.asiantech.demstudent;

import android.app.Application;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 04/01/2017.
 */
public class DemoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //init sugar data
//        initDataSugar();
        SugarContext.init(getApplicationContext());
    }

    /**
     * This method init data
     */
    private void initDataSugar() {
        SugarContext.terminate();
        SchemaGenerator schemaGenerator = new SchemaGenerator(getApplicationContext());
        schemaGenerator.deleteTables(new SugarDb(getApplicationContext()).getDB());
        SugarContext.init(getApplicationContext());
        schemaGenerator.createDatabase(new SugarDb(getApplicationContext()).getDB());
    }

}
