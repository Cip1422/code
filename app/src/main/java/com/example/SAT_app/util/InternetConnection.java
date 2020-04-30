package com.example.SAT_app.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

public class InternetConnection {
    private Context context;

    @Inject
    public InternetConnection(Context context) {
        this.context = context;
    }

    public boolean checkInternetConnectivity() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo.isConnected();
    }
}
