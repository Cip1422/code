package com.example.SAT_app.di.component;

import com.example.SAT_app.di.module.InternetModule;
import com.example.SAT_app.di.module.SchoolApplicationModule;
import com.example.SAT_app.di.module.RepositoryModule;
import com.example.SAT_app.di.module.SchoolNetworkFactoryModule;
import com.example.SAT_app.di.module.SchoolViewModelFactoryModule;
import com.example.SAT_app.view.MainActivity;

import dagger.Component;

@Component(modules = {InternetModule.class,
        SchoolNetworkFactoryModule.class,
        SchoolApplicationModule.class,
        SchoolViewModelFactoryModule.class,
        RepositoryModule.class})
public interface SchoolComponent {
    void inject(MainActivity activity);
}