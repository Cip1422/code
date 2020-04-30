package com.example.SAT_app.network;

import com.example.SAT_app.model.SAT;
import com.example.SAT_app.model.Schools;
import java.util.List;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface SchoolService {
    @GET
    Flowable<List<Schools>> getListSchools(@Url String url);
    @GET
    Flowable<List<SAT>> getListSATSchools(@Url String url);

}
