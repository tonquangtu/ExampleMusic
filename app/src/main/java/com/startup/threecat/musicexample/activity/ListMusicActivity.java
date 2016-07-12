package com.startup.threecat.musicexample.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.startup.threecat.musicexample.R;
import com.startup.threecat.musicexample.adapter.ReListSongAdapter;
import com.startup.threecat.musicexample.model.InfoSong;
import com.startup.threecat.musicexample.network.LoadListSong;
import com.startup.threecat.musicexample.util.SpaceItem;

import java.util.ArrayList;

public class ListMusicActivity extends AppCompatActivity {

    private RecyclerView rvListSong;
    private ProgressBar pbLoader;
    LoadListSong loadListSong;
    private ArrayList<InfoSong> listSong;
    ReListSongAdapter songAdapter;
    private String idAlbum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.PACKAGE);
        this.idAlbum = bundle.getString(MainActivity.ID_ALBUM);

        initView();
        loadListSong = new LoadListSong();
        new TaskLoadSong().execute();

    }

    public void initView() {

        pbLoader = (ProgressBar)findViewById(R.id.pbLoader);
        rvListSong = (RecyclerView)findViewById(R.id.recyclerListMusic);

        pbLoader.setVisibility(View.VISIBLE);
        rvListSong.setVisibility(View.GONE);
        pbLoader.setIndeterminate(true);
    }

    private class TaskLoadSong extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            loadListSong.loadInfoSong(idAlbum);
            while(loadListSong.getLoad() == LoadListSong.LOADING) {
                SystemClock.sleep(10);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            listSong = loadListSong.getListSong();
            int load = loadListSong.getLoad();
            if(load == LoadListSong.LOAD_SUCCESS && listSong != null) {
                initRecyclerView();
            }else {
                Toast.makeText(ListMusicActivity.this, "Can't load list song from album !",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    public void initRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvListSong.setLayoutManager(layoutManager);

        SpaceItem spaceItem = new SpaceItem(10, SpaceItem.VERTICAL, listSong.size());
        rvListSong.addItemDecoration(spaceItem);

        ReListSongAdapter.OnItemClickListener listener = new ReListSongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //do something when user click a song
                showPopupOption(view);
            }
        };
        songAdapter = new ReListSongAdapter(this, listener, listSong );
        rvListSong.setAdapter(songAdapter);

        pbLoader.setVisibility(View.GONE);
        rvListSong.setVisibility(View.VISIBLE);
    }

    public void showPopupOption(View v) {

        //Creating the instance of PopupMenu
        PopupMenu popup = new PopupMenu(ListMusicActivity.this, v);
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ListMusicActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();//showing popup menu
    }
}
