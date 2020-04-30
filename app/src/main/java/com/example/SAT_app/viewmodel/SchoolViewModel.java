package com.example.SAT_app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.SAT_app.model.SAT;
import com.example.SAT_app.model.Schools;
import com.example.SAT_app.network.Repository;

import java.util.List;

import javax.inject.Inject;

public class SchoolViewModel extends ViewModel{
    LiveData<List<Schools>> dataListSchools;
    private LiveData<List<SAT>> dataListSat;
    private Repository repository;

    @Inject
    public SchoolViewModel(Repository repository){
        this.repository = repository;
    }

    public void initNetworkCall() {
        setDataListSat();
        setDataListSchools();
    }

    private void setDataListSchools(){
        dataListSchools =  repository.getSchoolsFromObservable();
    }

    private void setDataListSat(){
        dataListSat = repository.getSATFromObservable();
    }

    public LiveData<List<Schools>> getDataListSchools(){
        return this.dataListSchools;
    }

    public LiveData<List<SAT>> getDataListSat(){
        return this.dataListSat;
    }
}