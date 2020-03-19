package com.android.nunu.ui.splash;


import android.widget.ImageView;

import com.android.nunu.data.DataManager;
import com.android.nunu.ui.base.BaseViewModel;
import com.android.nunu.utils.rx.SchedulerProvider;
import com.bumptech.glide.Glide;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    private final int SPLASH_TIME_OUT = 1500;


    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    // if you need seeding
//    public void startSeeding() {
//        getCompositeDisposable().add(getDataManager()
//                .seedDatabaseQuestions()
//                .flatMap(aBoolean -> getDataManager().seedDatabaseOptions())
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(aBoolean -> {
//                    decideNextActivity();
//                }, throwable -> {
//                    decideNextActivity();
//                }));
//    }
    void doSplashScreenWork() {

        decideNextActivity();

    }

    void loadSplashImage(int url, ImageView imageView) {

        Glide.with(imageView.getContext()).load(url).into(imageView);

    }

    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        } else {
            getNavigator().openHomeActivity();
        }
    }
}
