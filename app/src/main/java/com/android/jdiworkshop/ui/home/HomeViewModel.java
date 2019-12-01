package com.android.jdiworkshop.ui.home;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.jdiworkshop.data.DataManager;
import com.android.jdiworkshop.ui.base.BaseViewModel;
import com.android.jdiworkshop.utils.rx.SchedulerProvider;

import java.util.List;

import timber.log.Timber;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {

//    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;

    private final ObservableField<String> appVersion = new ObservableField<>();

//    private final MutableLiveData<List<QuestionCardData>> questionCardData;
//
//    private final ObservableList<QuestionCardData> questionDataList = new ObservableArrayList<>();

    private final ObservableField<String> userEmail = new ObservableField<>();

    private final ObservableField<String> userName = new ObservableField<>();

    private final ObservableField<String> userProfilePicUrl = new ObservableField<>();


    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
//        questionCardData = new MutableLiveData<>();
//        loadQuestionCards();
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
//        getCompositeDisposable().add(getDataManager()
//                .getQuestionCardData()
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(questionList -> {
//                    if (questionList != null) {
//                        action = ACTION_ADD_ALL;
//                        questionCardData.setValue(questionList);
//                    }
//                }, throwable -> {
//
//                }));
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

    public void onNavMenuCreated() {
        final String currentUserName = getDataManager().getCurrentUserName();
        if (!TextUtils.isEmpty(currentUserName)) {
            userName.set(currentUserName);
        }
        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (!TextUtils.isEmpty(currentUserEmail)) {
            userEmail.set(currentUserEmail);
        }


        final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
        if (!TextUtils.isEmpty(profilePicUrl)) {
            userProfilePicUrl.set(profilePicUrl);
        }

        Timber.i(currentUserEmail);
        Timber.i(currentUserName);
        Timber.i(profilePicUrl);

    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }


}
