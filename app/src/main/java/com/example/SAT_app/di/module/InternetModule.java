package com.example.SAT_app.di.module;

import android.content.Context;

import com.example.SAT_app.util.InternetConnection;

import dagger.Module;
import dagger.Provides;

@Module
public class InternetModule {

    @Provides
    public InternetConnection providesNetworkConnectivity(Context context){
        return new InternetConnection(context);
    }
}