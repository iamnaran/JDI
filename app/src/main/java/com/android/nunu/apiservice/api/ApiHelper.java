package com.android.nunu.apiservice.api;

import com.android.nunu.apiservice.HomeApiService;
import com.android.nunu.apiservice.LoginApiService;
import com.android.nunu.data.model.Home;
import com.android.nunu.data.model.User;

import io.reactivex.Single;

public interface ApiHelper {

    Single<User> doServerLoginRequest(LoginApiService.ServerLoginRequest request);

    Single<Home> doHomeApiRequest(HomeApiService.HomeApiRequest request);


    ApiHeader getApiHeader();

}





