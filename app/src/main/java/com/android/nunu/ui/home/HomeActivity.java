package com.android.nunu.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;

import com.android.nunu.BuildConfig;
import com.android.nunu.R;
import com.android.nunu.ViewModelProviderFactory;
import com.android.nunu.data.model.Home;
import com.android.nunu.databinding.ActivityHomeBinding;
import com.android.nunu.ui.base.BaseActivity;
import com.android.nunu.ui.login.LoginActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.GsonBuilder;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import javax.inject.Inject;

public class HomeActivity  extends BaseActivity<ActivityHomeBinding, HomeViewModel> implements HomeNavigator {

    @Inject
    ViewModelProviderFactory factory;
    HomeViewModel homeViewModel;

    private ActivityHomeBinding mActivityHomeBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return com.android.nunu.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        homeViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel.class);
        return homeViewModel;
    }


    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void onHomeApiDataReceived(Home home) {
        Log.e( "onHomeApiDataReceived: ", new GsonBuilder().create().toJson(home));
    }

    @Override
    public void onHomeApiDataFailure(String message) {

    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = getViewDataBinding();
        homeViewModel.setNavigator(this);
        setUp();
    }



    private void setUp() {
//        String version = getString(R.string.version) + " " + BuildConfig.VERSION_NAME;
//        homeViewModel.updateAppVersion(version);

//        setupCardContainerView();
        subscribeToLiveData();

    }

    private void subscribeToLiveData() {
        homeViewModel.getHomeResponseData().observe(this, homeData -> homeViewModel.setHomeDataList(homeData));

    }

}
