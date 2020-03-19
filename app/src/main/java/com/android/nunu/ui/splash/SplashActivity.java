package com.android.nunu.ui.splash;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.android.nunu.R;
import com.android.nunu.ViewModelProviderFactory;
import com.android.nunu.databinding.ActivitySplashBinding;
import com.android.nunu.ui.base.BaseActivity;
import com.android.nunu.ui.home.HomeActivity;
import com.android.nunu.ui.login.LoginActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    ViewModelProviderFactory factory;
    SplashViewModel mSplashViewModel;
    ActivitySplashBinding activitySplashBinding;

    private final int SPLASH_TIME_OUT = 1500;


    @Override
    public int getBindingVariable() {
        return com.android.nunu.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this, factory).get(SplashViewModel.class);
        return mSplashViewModel;
    }


    @Override
    public void openHomeActivity() {

        new Handler().postDelayed(() -> {
            Intent intent = HomeActivity.newIntent(SplashActivity.this);
            startActivity(intent);
            finish();
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void openLoginActivity() {
            Intent intent = LoginActivity.newIntent(SplashActivity.this);
            startActivity(intent);
            finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashBinding = getViewDataBinding();
        mSplashViewModel.loadSplashImage(R.drawable.ic_app_logo, activitySplashBinding.imageView);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.doSplashScreenWork();

    }
}
