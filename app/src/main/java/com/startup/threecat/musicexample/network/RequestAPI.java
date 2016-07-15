package com.startup.threecat.musicexample.network;

import com.startup.threecat.musicexample.model.RequestResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dell on 12-Jul-16.
 */
public interface RequestAPI {
    @GET("artists/{id}/releases")
    Call<RequestResult> requestInfoSongs(@Path("id") String id);

}
