package com.startup.threecat.musicexample.network;

import com.startup.threecat.musicexample.model.InfoSong;
import com.startup.threecat.musicexample.model.RequestResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dell on 12-Jul-16.
 */
public class LoadListSong {

    public static final int LOAD_SUCCESS = 1;
    public static final int LOAD_FAIL = 2;
    public static final int LOADING = 0;
    private int load;
    private ArrayList<InfoSong> listSong;

    public void loadInfoSong(String id) {

        load = LOADING;
        Call<RequestResult> call = ConnectServer.getRequestAPI().requestInfoSongs(id);
        call.enqueue(new Callback<RequestResult>() {
            @Override
            public void onResponse(Call<RequestResult> call, Response<RequestResult> response) {

                if(response != null && response.isSuccessful()) {
                    RequestResult result = response.body();
                    if(result != null) {
                        listSong = result.getReleases();
                        load = LOAD_SUCCESS;
                    }else {
                        load = LOAD_FAIL;
                    }
                }else {
                    load = LOAD_FAIL;
                }
            }

            @Override
            public void onFailure(Call<RequestResult> call, Throwable t) {
                load = LOAD_FAIL;
            }
        });
    }

    public int getLoad() {
        return load;
    }

    public ArrayList<InfoSong> getListSong() {
        return listSong;
    }



}
