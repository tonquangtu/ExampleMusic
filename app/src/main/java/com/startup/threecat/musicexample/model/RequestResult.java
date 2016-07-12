package com.startup.threecat.musicexample.model;

import java.util.ArrayList;

/**
 * Created by Dell on 12-Jul-16.
 */
public class RequestResult {

    private ArrayList<InfoSong> releases;

    public ArrayList<InfoSong> getReleases() {
        return releases;
    }

    public void setReleases(ArrayList<InfoSong> releases) {
        this.releases = releases;
    }
}
