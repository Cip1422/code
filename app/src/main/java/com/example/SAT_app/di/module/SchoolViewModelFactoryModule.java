package com.example.SAT_app.di.module;

import com.example.SAT_app.network.Repository;
import com.example.SAT_app.viewmodel.SchoolViewModelFactory;

import dagger.Module;
import dagger.Provides;


@Module
public class SchoolViewModelFactoryModule {

  @Provides
  public SchoolViewModelFactory providesViewModelFactory(Repository repository){
    return new SchoolViewModelFactory(repository);
  }
}