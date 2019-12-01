package com.android.jdiworkshop.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.android.jdiworkshop.R;
import com.android.jdiworkshop.ViewModelProviderFactory;
import com.android.jdiworkshop.databinding.ActivitySplashBinding;
import com.android.jdiworkshop.ui.base.BaseActivity;
import com.android.jdiworkshop.ui.home.HomeActivity;
import com.android.jdiworkshop.ui.login.LoginActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    ViewModelProviderFactory factory;
    SplashViewModel mSplashViewModel;

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
        mSplashViewModel = ViewModelProviders.of(this,factory).get(SplashViewModel.class);
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
        Intent intent = HomeActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.doSplashScreenWork();

    }
}
