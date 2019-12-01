package com.android.jdiworkshop;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.android.jdiworkshop.data.DataManager;
import com.android.jdiworkshop.ui.home.HomeViewModel;
import com.android.jdiworkshop.ui.login.LoginViewModel;
import com.android.jdiworkshop.ui.splash.SplashViewModel;
import com.android.jdiworkshop.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

  private final DataManager dataManager;
  private final SchedulerProvider schedulerProvider;

  @Inject
  public ViewModelProviderFactory(DataManager dataManager,
                                  SchedulerProvider schedulerProvider) {
    this.dataManager = dataManager;
    this.schedulerProvider = schedulerProvider;
  }


  @NonNull
  @Override
  public <T extends ViewModel> T create(Class<T> modelClass) {
    if (modelClass.isAssignableFrom(LoginViewModel.class)) {
      //noinspection unchecked
      return (T) new LoginViewModel(dataManager,schedulerProvider);
    } else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
      //noinspection unchecked
      return (T) new SplashViewModel(dataManager,schedulerProvider);
    } else if (modelClass.isAssignableFrom(HomeViewModel.class)) {
      //noinspection unchecked
      return (T) new HomeViewModel(dataManager,schedulerProvider);
    }
    throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
  }
}