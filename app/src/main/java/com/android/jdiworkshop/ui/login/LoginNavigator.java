package com.android.jdiworkshop.ui.login;

public interface LoginNavigator {

    void handleError(Throwable throwable);

    void login();

    void doLoginSuccessWork();

}
