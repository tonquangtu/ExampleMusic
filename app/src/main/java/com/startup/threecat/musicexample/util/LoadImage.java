package com.startup.threecat.musicexample.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.startup.threecat.musicexample.R;

import java.util.Random;

/**
 * Created by Dell on 12-Jul-16.
 */
public class LoadImage {

    /**
     * Load image from resource,
     * Use picasso library to load image
     * @param context : Context contain ImageView
     * @param imageView : ImageView want to load image into it
     * @param res : id of image in resource
     */
    public static void loadImageAlbum(Context context, ImageView imageView, int res) {

        Picasso.with(context)
                .load(res)
                .resize(600, 600)
                .centerCrop()
                .placeholder(R.drawable.place_holder)
                .into(imageView);
    }

    public static void loadImageSong(Context context, ImageView imageView) {

        Random random = new Random();
        int index = random.nextInt();
        int res = R.drawable.song2;

        Picasso.with(context)
                .load(res)
                .resize(90, 90)
                .centerCrop()
                .placeholder(R.drawable.place_holder)
                .into(imageView);
    }
}
