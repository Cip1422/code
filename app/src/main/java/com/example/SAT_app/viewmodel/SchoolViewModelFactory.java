package com.example.SAT_app.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.SAT_app.network.Repository;

import javax.inject.Inject;

public class SchoolViewModelFactory implements ViewModelProvider.Factory {

    private Repository repository;

    @Inject
    public SchoolViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        SchoolViewModel viewModel = new SchoolViewModel(repository);
        return (T) viewModel;
    }
}