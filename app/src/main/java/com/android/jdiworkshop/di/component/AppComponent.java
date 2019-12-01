package com.android.jdiworkshop.di.component;

import android.app.Application;

import com.android.jdiworkshop.MyApplication;
import com.android.jdiworkshop.di.module.AppModule;
import com.android.jdiworkshop.di.builder.ActivityBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MyApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
