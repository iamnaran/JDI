package com.android.jdiworkshop.ui.splash;


import android.os.Handler;

import com.android.jdiworkshop.data.DataManager;
import com.android.jdiworkshop.ui.base.BaseViewModel;
import com.android.jdiworkshop.utils.rx.SchedulerProvider;

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


    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        } else {
            getNavigator().openHomeActivity();
        }
    }
}
