package com.example.SAT_app.di.module;


import android.content.Context;

import com.example.SAT_app.util.SchoolApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class SchoolApplicationModule {

    private SchoolApplication context;

    public SchoolApplicationModule(SchoolApplication context){
        this.context = context;
    }

    @Provides
    public Context providesApplicationContext(){
        return context.getApplicationContext();
    }
}
