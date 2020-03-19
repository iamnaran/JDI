package com.android.nunu.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

import com.android.nunu.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public final class CommonUtils {

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getTimestamp() {
        return new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(new Date());
    }

    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static String loadJSONFromAsset(Context context, String jsonFileName) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, "UTF-8");
    }



    public static String getCurrentDatAndTime(){

        return new SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.getDefault()).format(new Date());

    }


    public static String formatDayToServerDate(String unformattedDate) {
        String currentTimeZoneDate = "";
        try {
            DateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.getDefault());
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
            Date date = sdf.parse(unformattedDate);
            sdf.setTimeZone(TimeZone.getDefault());
            currentTimeZoneDate = sdf.format(date);
            date = sdf.parse(currentTimeZoneDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            currentTimeZoneDate = simpleDateFormat.format(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return currentTimeZoneDate;
    }

    public static String formatToClientFullDateTime(String unformattedDate) {
        String currentTimeZoneDate = "";
        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+5:45"));
            Date date = sdf.parse(unformattedDate);
            currentTimeZoneDate = sdf.format(date);
            date = sdf.parse(currentTimeZoneDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.ENGLISH);
            currentTimeZoneDate = simpleDateFormat.format(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return currentTimeZoneDate;
    }

    public static Spanned fromHtml(String source) {
        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(source);
        }
    }


    public static String setTextHighlight(String inputText) {

        return "This is <font color='red'> " + inputText + " </font>.";

    }

    public static void showSnackBar(final Context context, View view, String message) {

        final Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_SHORT);

        snackbar.setActionTextColor(Color.WHITE);

        View sbView = snackbar.getView();
        sbView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        snackbar.setDuration(3000);
        TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
        textView.setTextColor(context.getResources().getColor(R.color.bg_color));
        snackbar.show();
    }








}
