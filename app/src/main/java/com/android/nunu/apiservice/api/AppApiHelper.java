package com.android.nunu.apiservice.api;

import com.android.nunu.apiservice.HomeApiService;
import com.android.nunu.apiservice.LoginApiService;
import com.android.nunu.data.model.Home;
import com.android.nunu.data.model.User;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }


//    @Override
//    public Single<LogoutResponse> doLogoutApiCall() {
//        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
//                .addHeaders(mApiHeader.getProtectedApiHeader())
//                .build()
//                .getObjectSingle(LogoutResponse.class);
//    }

    @Override
    public Single<User> doServerLoginRequest(LoginApiService.ServerLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(User.class);
    }


    @Override
    public Single<Home> doHomeApiRequest(HomeApiService.HomeApiRequest request) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVER_HOME)
                .build()
                .getObjectSingle(Home.class);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

}
