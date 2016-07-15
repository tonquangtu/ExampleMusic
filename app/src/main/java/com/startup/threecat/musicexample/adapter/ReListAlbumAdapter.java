package com.startup.threecat.musicexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.startup.threecat.musicexample.R;
import com.startup.threecat.musicexample.model.Album;
import com.startup.threecat.musicexample.util.LoadImage;

import java.util.ArrayList;

/**
 * Created by Dell on 12-Jul-16.
 */
public class ReListAlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static Context context;
    private ArrayList<Album> listAlbum;

    /**
     * it is interface to catch listener when user click a item in RecyclerView
     */
    public interface OnItemClickListener {
        /**
         * Method use to catch listener when use click a item in list
         * @param view : View contain subviews in a item
         * @param position : special position of item in list
         */
        public void onItemClick(View view, int position);
    }

    private OnItemClickListener listener;

    public ReListAlbumAdapter(Context context,
                              OnItemClickListener listener,
                              ArrayList<Album> listAlbum) {
        this.context = context;
        this.listener = listener;
        this.listAlbum = listAlbum;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view_artirt, parent, false);
        AlbumHolder holder = new AlbumHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        AlbumHolder albumHolder = (AlbumHolder)holder;
        albumHolder.populateData(listAlbum.get(position));
        albumHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAlbum.size();
    }

    /**
     * It is class use create ViewHolder
     */
    private static class AlbumHolder extends RecyclerView.ViewHolder {

        TextView txtAlbumName;
        TextView txtArtist;
        ImageView imgAlbum;

        public AlbumHolder(View itemView) {
            super(itemView);

            txtAlbumName = (TextView)itemView.findViewById(R.id.txtAlbumName);
            txtArtist = (TextView)itemView.findViewById(R.id.txtArtistName);
            imgAlbum = (ImageView)itemView.findViewById(R.id.imgAlbum);
        }

        public void populateData(Album album) {

            txtAlbumName.setText(album.getName());
            txtArtist.setText(album.getArtist());
            LoadImage.loadImageAlbum(context, imgAlbum, album.getIdResImage());
        }
    }
}

