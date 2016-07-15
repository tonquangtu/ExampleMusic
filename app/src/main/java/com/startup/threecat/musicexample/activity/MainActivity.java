package com.startup.threecat.musicexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.startup.threecat.musicexample.R;
import com.startup.threecat.musicexample.adapter.ReListAlbumAdapter;
import com.startup.threecat.musicexample.model.Album;
import com.startup.threecat.musicexample.util.DummyData;
import com.startup.threecat.musicexample.util.SpaceItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView reListAlbum;
    ReListAlbumAdapter albumAdapter;
    ArrayList<Album> listAlbum;
    public static final String ID_ALBUM = "ID_ALBUM";
    public static final String PACKAGE = "PACKAGE";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAlbum = DummyData.initData();
        initView();
    }

    /**
     * init view for main screen
     */
    public void initView() {

        reListAlbum = (RecyclerView)this.findViewById(R.id.recyclerListAlbum);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        reListAlbum.setLayoutManager(layoutManager);

        SpaceItem spaceItem = new SpaceItem(10, SpaceItem.GRID, listAlbum.size());
        reListAlbum.addItemDecoration(spaceItem);

        ReListAlbumAdapter.OnItemClickListener onItemClickListener =
                new ReListAlbumAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        handleOnClickItem(position);
                        // do something
                    }
                };

        albumAdapter = new ReListAlbumAdapter(this, onItemClickListener, listAlbum);
        reListAlbum.setAdapter(albumAdapter);

//        imgBtnOption.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPopupMenu(v);
//            }
//        });

    }

//    public void showPopupMenu(View view) {
//        //Creating the instance of PopupMenu
//        PopupMenu popup = new PopupMenu(MainActivity.this, imgBtnOption);
//        //Inflating the Popup using xml file
//        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
//
//        //registering popup with OnMenuItemClickListener
//        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//
//        popup.show();//showing popup menu
//    }

    
    public void handleOnClickItem(int position) {

        Album album = listAlbum.get(position);
        String id = album.getIdAlbum();

        Intent intent = new Intent(this, ListMusicActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(ID_ALBUM, id);
        intent.putExtra(PACKAGE, bundle);
        startActivity(intent);
    }
}
