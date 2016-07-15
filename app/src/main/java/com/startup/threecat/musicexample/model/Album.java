package com.startup.threecat.musicexample.model;

/**
 * Created by Dell on 12-Jul-16.
 */
public class Album {
    private String name;
    private String artist;
    private int idResImage;
    private String linkAlbum;
    private String idAlbum;

    public Album(String idAlbum, String name, String artist,
                 int idResImage, String linkAlbum) {
        this.name = name;
        this.artist = artist;
        this.idResImage = idResImage;
        this.linkAlbum = linkAlbum;
        this.idAlbum = idAlbum;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getIdResImage() {
        return idResImage;
    }

    public String getLinkAlbum() {
        return linkAlbum;
    }

    public String getIdAlbum() {
        return idAlbum;
    }
}