package com.android.nunu.apiservice.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ApiError {

    private int errorCode;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("status_code")
    private String statusCode;

    public ApiError(int errorCode, String statusCode, String message) {
        this.errorCode = errorCode;
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        ApiError apiError = (ApiError) object;

        if (errorCode != apiError.errorCode) {
            return false;
        }
        if (statusCode != null ? !statusCode.equals(apiError.statusCode)
                : apiError.statusCode != null) {
            return false;
        }
        return message != null ? message.equals(apiError.message) : apiError.message == null;

    }

    @Override
    public int hashCode() {
        int result = errorCode;
        result = 31 * result + (statusCode != null ? statusCode.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
