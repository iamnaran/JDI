package com.android.nunu.data;

import com.android.nunu.apiservice.api.ApiHelper;
import com.android.nunu.data.helpers.PreferencesHelper;
import com.android.nunu.data.model.Home;

public interface DataManager extends PreferencesHelper, ApiHelper {

    void setUserAsLoggedOut();

    void updateApiHeader(Long userId, String accessToken);

    void updateUserInfo(
            String accessToken,
            Integer userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }

    }

    @Override
    void setHomeResponseData(Home homeResponseData);

    @Override
    Home getHomeResponseData();
}