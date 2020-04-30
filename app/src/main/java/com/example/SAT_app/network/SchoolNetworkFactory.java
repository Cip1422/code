package com.example.SAT_app.network;

import android.content.Context;

import com.example.SAT_app.R;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolNetworkFactory {

    private Context context;

    @Inject
    public SchoolNetworkFactory(Context context) {
        this.context = context;
    }

    public SchoolService getApi() {
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(SchoolService.class);
    }

}
