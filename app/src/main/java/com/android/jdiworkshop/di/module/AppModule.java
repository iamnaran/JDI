package com.android.jdiworkshop.di.module;


import android.app.Application;
import android.content.Context;

import com.android.jdiworkshop.R;
import com.android.jdiworkshop.apiservice.api.ApiHeader;
import com.android.jdiworkshop.apiservice.api.ApiHelper;
import com.android.jdiworkshop.apiservice.api.AppApiHelper;
import com.android.jdiworkshop.data.AppDataManager;
import com.android.jdiworkshop.data.DataManager;
import com.android.jdiworkshop.data.helpers.AppPreferencesHelper;
import com.android.jdiworkshop.data.helpers.PreferencesHelper;
import com.android.jdiworkshop.di.ApiInfo;
import com.android.jdiworkshop.di.PreferenceInfo;
import com.android.jdiworkshop.utils.AppConstants;
import com.android.jdiworkshop.utils.rx.AppSchedulerProvider;
import com.android.jdiworkshop.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(preferencesHelper.getAccessToken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }



}
