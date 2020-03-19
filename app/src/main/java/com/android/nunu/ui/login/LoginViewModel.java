package com.android.nunu.ui.login;

import android.text.TextUtils;

import com.android.nunu.apiservice.LoginApiService;
import com.android.nunu.data.DataManager;
import com.android.nunu.ui.base.BaseViewModel;
import com.android.nunu.utils.AppLogger;
import com.android.nunu.utils.CommonUtils;
import com.android.nunu.utils.rx.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {

        AppLogger.d(email,password);

        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doServerLoginRequest(new LoginApiService.ServerLoginRequest(email, password))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(
                                response.getUserDetails().getToken(),
                                response.getUserDetails().getId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getUserDetails().getFirstName(),
                                response.getUserDetails().getEmail(),
                                response.getUserDetails().getImage()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().doLoginSuccessWork();

                }, throwable -> {

                    setIsLoading(false);
                    getNavigator().handleError(throwable);

                }));
    }

    public void onServerLoginClick() {
        getNavigator().login();
    }




//    public void onFbLoginClick() {
//        setIsLoading(true);
//        getCompositeDisposable().add(getDataManager()
//                .doFacebookLoginApiCall(new LoginRequest.FacebookLoginRequest("test3", "test4"))
//                .doOnSuccess(response -> getDataManager()
//                        .updateUserInfo(
//                                response.getAccessToken(),
//                                response.getUserId(),
//                                DataManager.LoggedInMode.LOGGED_IN_MODE_FB,
//                                response.getUserName(),
//                                response.getUserEmail(),
//                                response.getGoogleProfilePicUrl()))
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(response -> {
//                    setIsLoading(false);
//                    getNavigator().openHomeActivity();
//                }, throwable -> {
//                    setIsLoading(false);
//                    getNavigator().handleError(throwable);
//                }));
//    }
}
