package com.example.SAT_app.util;

import android.app.Application;


import com.example.SAT_app.di.component.DaggerSchoolComponent;
import com.example.SAT_app.di.component.SchoolComponent;
import com.example.SAT_app.di.module.InternetModule;
import com.example.SAT_app.di.module.SchoolApplicationModule;
import com.example.SAT_app.di.module.SchoolViewModelFactoryModule;
import com.example.SAT_app.di.module.SchoolNetworkFactoryModule;
import com.example.SAT_app.di.module.RepositoryModule;

public class SchoolApplication extends Application {
    private static SchoolComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerSchoolComponent.builder()
                .internetModule(new InternetModule())
                .schoolViewModelFactoryModule(new SchoolViewModelFactoryModule())
                .schoolNetworkFactoryModule(new SchoolNetworkFactoryModule())
                .repositoryModule(new RepositoryModule())
                .schoolApplicationModule(new SchoolApplicationModule(this))
                .build();
    }

    public static SchoolComponent getComponent() {
        return component;
    }
}

