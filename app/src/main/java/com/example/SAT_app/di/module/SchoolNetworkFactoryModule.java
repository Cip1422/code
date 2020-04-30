package com.example.SAT_app.di.module;

import android.content.Context;

import com.example.SAT_app.network.SchoolNetworkFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SchoolNetworkFactoryModule {

    @Provides
    public SchoolNetworkFactory providesNetwork(Context context){
        return new SchoolNetworkFactory(context);
    }
}
