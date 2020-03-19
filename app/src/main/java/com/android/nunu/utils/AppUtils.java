package com.android.nunu.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.android.nunu.R;
import com.bumptech.glide.load.HttpException;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonSyntaxException;

import javax.net.ssl.HttpsURLConnection;


public final class AppUtils {

    private AppUtils() {
        // This class is not publicly instantiable
    }

    public static void openPlayStoreForApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_market_link) + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_google_play_store_link) + appPackageName)));
        }
    }


    public static void showSnackBarWithError(View view, Throwable error) {

        Snackbar snackbar = Snackbar
                .make(view, handleApiError(error), Snackbar.LENGTH_LONG)
                .setAction("RETRY", view1 -> {

                });
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

    }

    public static String handleApiError(Throwable error) {

        if (error instanceof HttpException) {

            switch (((HttpException) error).getStatusCode()) {


                //422, 401,404
                case HttpsURLConnection.HTTP_NOT_FOUND:

                    return "Error code 404 not found,  Please try again later.";

                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    return "HTTP Unauthorised user access error, Please contact our support.";
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    return "Forbidden error . Logout & Re-login if you are facing some error.";
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    return "Internal Server Error. Please try again later.";

                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    return "Sorry! Bad Request. Please try again later.";
                case 0:
                    return "No Internet Connection.  Please try again later.";
                default:
                    return error.getLocalizedMessage();

            }
        } else if (error instanceof JsonSyntaxException) {
            return "Something Went Wrong. PLease contact our support!";
        } else {
            return error.getMessage();
        }
    }

}
