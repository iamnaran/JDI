package com.android.nunu.ui.home;

import android.text.TextUtils;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.nunu.apiservice.HomeApiService;
import com.android.nunu.apiservice.LoginApiService;
import com.android.nunu.data.DataManager;
import com.android.nunu.data.model.Home;
import com.android.nunu.ui.base.BaseViewModel;
import com.android.nunu.utils.rx.SchedulerProvider;

import java.util.List;

import timber.log.Timber;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {

    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;

    private final ObservableField<String> appVersion = new ObservableField<>();

    private final MutableLiveData<List<Home.Datum>> homeResponseData;

    private final ObservableList<Home.Datum> homeDataList = new ObservableArrayList<>();

    private final ObservableField<String> userEmail = new ObservableField<>();

    private final ObservableField<String> userName = new ObservableField<>();

    private final ObservableField<String> userProfilePicUrl = new ObservableField<>();
    private int action = NO_ACTION;


    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        homeResponseData = new MutableLiveData<>();
        loadHomeData();
    }


    public int getAction() {
        return action;
    }


    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public ObservableField<String> getUserEmail() {
        return userEmail;
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public ObservableField<String> getUserProfilePicUrl() {
        return userProfilePicUrl;
    }

    public void loadHomeData() {

        getCompositeDisposable().add(getDataManager()
                .doHomeApiRequest(new HomeApiService.HomeApiRequest())
                .doOnSuccess(response -> getDataManager().setHomeResponseData(response))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {

                    if (response != null){

                    }

                    setIsLoading(false);
                    getNavigator().onHomeApiDataReceived(response);

                }, throwable -> {

                    setIsLoading(false);
                    getNavigator().handleError(throwable);

                }));

    }

    public void logout() {
//        setIsLoading(true);
//        getCompositeDisposable().add(getDataManager().doLogoutApiCall()
//                .doOnSuccess(response -> getDataManager().setUserAsLoggedOut())
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(response -> {
//                    setIsLoading(false);
//                    getNavigator().openLoginActivity();
//                }, throwable -> {
//                    setIsLoading(false);
//                    getNavigator().handleError(throwable);
//                }));
    }


    public LiveData<List<Home.Datum>> getHomeResponseData() {
        return homeResponseData;
    }


    public void setHomeDataList(List<Home.Datum> dataList) {
        action = ACTION_ADD_ALL;
        homeDataList.clear();
        homeDataList.addAll(dataList);
    }


    public ObservableList<Home.Datum> getHomeDataList() {
        return homeDataList;
    }


    public void removeSingleData() {
        action = ACTION_DELETE_SINGLE;
        try{
            if (homeResponseData != null){
                homeResponseData.getValue().remove(0);
            }
        }catch (Exception ignored){

        }
    }



    public void updateAppVersion(String version) {
        appVersion.set(version);
    }


}
