package com.android.nunu.apiservice.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ApiHeader {

    private ProtectedApiHeader mProtectedApiHeader;
    @Inject
    public ApiHeader(ProtectedApiHeader protectedApiHeader) {
        mProtectedApiHeader = protectedApiHeader;
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return mProtectedApiHeader;
    }


    public static final class ProtectedApiHeader {

        @Expose
        @SerializedName("token")
        private String mAccessToken;

//        @Expose
//        @SerializedName("api_key")
//        private String mApiKey;
//
//        @Expose
//        @SerializedName("user_id")
//        private Long mUserId;

        public ProtectedApiHeader(String mAccessToken) {
            this.mAccessToken = mAccessToken;
        }

        public String getAccessToken() {
            return mAccessToken;
        }

        public void setAccessToken(String accessToken) {
            mAccessToken = accessToken;
        }



    }

}
