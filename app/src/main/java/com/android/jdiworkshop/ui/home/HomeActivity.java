package com.android.jdiworkshop.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.jdiworkshop.R;
import com.android.jdiworkshop.ViewModelProviderFactory;
import com.android.jdiworkshop.databinding.ActivityHomeBinding;
import com.android.jdiworkshop.ui.base.BaseActivity;
import com.android.jdiworkshop.ui.login.LoginActivity;
import com.google.android.material.navigation.NavigationView;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

public class HomeActivity  extends BaseActivity<ActivityHomeBinding, HomeViewModel> implements HomeNavigator {

    @Inject
    ViewModelProviderFactory factory;
    HomeViewModel homeViewModel;

    private ActivityHomeBinding mActivityHomeBinding;
    private SwipePlaceHolderView mCardsContainerView;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;


    public static Intent newIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return com.android.jdiworkshop.BR.viewModel;
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
        homeViewModel.onNavMenuCreated();


    }
}
