package com.android.nunu.di.builder;


import com.android.nunu.ui.home.HomeActivity;
import com.android.nunu.ui.login.LoginActivity;
import com.android.nunu.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract HomeActivity bindHomeActivity();



//    @ContributesAndroidInjector(modules = {
//            FeedActivityModule.class,
//            BlogFragmentProvider.class,
//            OpenSourceFragmentProvider.class})

//    abstract FeedActivity bindFeedActivity();

//    @ContributesAndroidInjector(modules = {
//            AboutFragmentProvider.class,
//            RateUsDialogProvider.class})
//    abstract HomeActivity bindMainActivity();
//
}
