package com.example.SAT_app.network;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.example.SAT_app.R;
import com.example.SAT_app.model.SAT;
import com.example.SAT_app.model.Schools;
import com.example.SAT_app.util.InternetConnection;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class Repository {
    private InternetConnection internetConnection;
    private SchoolService service;
    private Context context;
    private String TAG = "Repository";

    @Inject
    public Repository(Context context,
                      SchoolNetworkFactory schoolNetworkFactory,
                      InternetConnection internetConnection) {
        this.context = context;
        this.internetConnection = internetConnection;
        service = schoolNetworkFactory.getApi();
    }
    public LiveData<List<Schools>> getSchoolsFromObservable() {
        Log.d(TAG, "getSchoolsFromObservable: ");
        return  LiveDataReactiveStreams.fromPublisher(
                service.getListSchools(context.getString(R.string.school_list_endpoint))
                        .doOnError(new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d(TAG, throwable.getMessage());
                            }
                        })
                        .subscribeOn(Schedulers.io())
        );
    }

    public LiveData<List<SAT>> getSATFromObservable(){
        return LiveDataReactiveStreams.fromPublisher(
                service.getListSATSchools(context.getString(R.string.sat_scores_endpoint))
                        .subscribeOn(Schedulers.io())
        );
    }

}