package com.android.jdiworkshop.apiservice.api;

import com.android.jdiworkshop.BuildConfig;

public final class ApiEndPoint {


    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL + "/login";


    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
