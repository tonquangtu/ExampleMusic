package com.startup.threecat.musicexample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dell on 12-Jul-16.
 */
public class ConnectServer {

    private static RequestAPI requestAPI = null;
    public static final String URL_BASE = "https://api.discogs.com/";

    public static RequestAPI getRequestAPI() {
        if(requestAPI == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(URL_BASE);
            builder.addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            requestAPI = retrofit.create(RequestAPI.class);
        }
        return requestAPI;
    }
}
