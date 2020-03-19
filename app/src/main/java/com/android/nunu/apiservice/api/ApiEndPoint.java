package com.android.nunu.apiservice.api;

import com.android.nunu.BuildConfig;

public final class ApiEndPoint {


    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL + "/login";
    public static final String ENDPOINT_SERVER_HOME = BuildConfig.BASE_URL + "/home";


    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
