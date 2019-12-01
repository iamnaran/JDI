package com.android.jdiworkshop.di.builder;


import com.android.jdiworkshop.ui.home.HomeActivity;
import com.android.jdiworkshop.ui.login.LoginActivity;
import com.android.jdiworkshop.ui.splash.SplashActivity;

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
