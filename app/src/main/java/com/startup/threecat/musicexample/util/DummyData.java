package com.startup.threecat.musicexample.util;

import com.startup.threecat.musicexample.R;
import com.startup.threecat.musicexample.model.Album;

import java.util.ArrayList;

/**
 * Created by Dell on 12-Jul-16.
 */
public class DummyData {
    /**
     * init data for test
     * @return
     */
    public static ArrayList<Album> initData() {

        ArrayList<Album> listAlbum = new ArrayList<>();
        Album temp;

        temp = new Album("1124645","Album 1",
                "Taylor Swift",
                R.drawable.taylor_swift_1,
                "https://api.discogs.com/artists/1124645/releases" );
        listAlbum.add(temp);

        temp = new Album("125992","Album 2",
                "AvrilLavigne",
                R.drawable.avrillavigne,
                "https://api.discogs.com/artists/125992/releases" );
        listAlbum.add(temp);

        temp = new Album("819015","Album 3",
                "Adele",
                R.drawable.adele,
                "https://api.discogs.com/artists/819015/releases" );
        listAlbum.add(temp);

        temp = new Album("1642600","Album 4",
                "Selena_Gomez",
                R.drawable.selena_gomez,
                "https://api.discogs.com/artists/1642600/releases" );
        listAlbum.add(temp);

        temp = new Album("2710776","Album 4",
                "Carly Rae Jepsen",
                R.drawable.carly_rae_jepsen,
                "https://api.discogs.com/artists/2710776/releases" );
        listAlbum.add(temp);

        temp = new Album("201543","Album 4",
                "Kelly Clarkson",
                R.drawable.kelly_clarkson,
                "https://api.discogs.com/artists/201543/releases" );
        listAlbum.add(temp);

        return listAlbum;
    }
}
