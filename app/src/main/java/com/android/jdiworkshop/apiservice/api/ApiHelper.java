package com.android.jdiworkshop.apiservice.api;

import com.android.jdiworkshop.apiservice.LoginApiService;
import com.android.jdiworkshop.data.model.User;

import io.reactivex.Single;

public interface ApiHelper {

    Single<User> doServerLoginRequest(LoginApiService.ServerLoginRequest request);

//    Single<BlogResponse> getBlogApiCall();
//    Single<OpenSourceResponse> getOpenSourceApiCall();

    ApiHeader getApiHeader();

}





