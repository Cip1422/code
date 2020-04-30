package com.example.SAT_app.di.module;

import android.content.Context;

import com.example.SAT_app.network.Repository;
import com.example.SAT_app.network.SchoolNetworkFactory;
import com.example.SAT_app.util.InternetConnection;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public Repository providesRepository(Context context,
                                         SchoolNetworkFactory schoolNetworkFactory,
                                         InternetConnection internetConnection){
        return new Repository(context, schoolNetworkFactory, internetConnection);
    }
}
