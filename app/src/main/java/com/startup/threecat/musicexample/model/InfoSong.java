package com.startup.threecat.musicexample.model;

/**
 * Created by Dell on 12-Jul-16.
 */
public class InfoSong {

    private String title;
    private String resource_url;
    private String year;
    private String artist;
    private String id;
    private String lable;

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfoSong() {
        String info = "";
        if(artist == null || artist.equals("")) {
            artist = "Unknow";
        }
        if(year == null) {
            year = "Unknow";
        }
        if(lable == null || lable.equals("")) {
            lable = "Unknow";
        }
        info = artist + "|" + year + "|" + lable;
        return info;
    }
}
