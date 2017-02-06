package com.example.asiantech.demstudent.network.core;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 10/01/2017.
 */
public class ApiClient {
    public static final int REQUEST_TIME_OUT = 10000;

    public enum ApiError {
        BAD_REQUEST(404),
        UNAUTHORIZED(400);

        public final int code;

        ApiError(int code) {
            this.code = code;
        }
    }
}
