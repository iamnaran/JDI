package com.android.nunu.ui.home;


import com.android.nunu.data.model.Home;

public interface HomeNavigator {

    void handleError(Throwable throwable);

    void onHomeApiDataReceived(Home home);

    void onHomeApiDataFailure(String message);

    void openLoginActivity();
}
