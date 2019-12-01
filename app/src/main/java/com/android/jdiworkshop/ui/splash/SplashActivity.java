package com.android.jdiworkshop.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.android.jdiworkshop.BR;
import com.android.jdiworkshop.R;
import com.android.jdiworkshop.ViewModelProviderFactory;
import com.android.jdiworkshop.databinding.ActivitySplashBinding;
import com.android.jdiworkshop.ui.base.BaseActivity;
import com.android.jdiworkshop.ui.home.HomeActivity;
import com.android.jdiworkshop.ui.login.LoginActivity;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    ViewModelProviderFactory factory;
    SplashViewModel mSplashViewModel;
    ActivitySplashBinding activitySplashBinding;

    private final int SPLASH_TIME_OUT = 1500;


    @Override
    public int getBindingVariable() {
        return com.android.jdiworkshop.BR.viewModel;
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
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashBinding = getViewDataBinding();
        mSplashViewModel.loadSplashImage(R.drawable.ic_app_logo, activitySplashBinding.imageView);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.doSplashScreenWork();

    }
}
