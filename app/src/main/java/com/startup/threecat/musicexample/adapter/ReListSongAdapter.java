package com.startup.threecat.musicexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.startup.threecat.musicexample.R;
import com.startup.threecat.musicexample.model.InfoSong;
import com.startup.threecat.musicexample.util.LoadImage;

import java.util.ArrayList;

/**
 * Created by Dell on 12-Jul-16.
 */
public class ReListSongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static Context context;
    private ArrayList<InfoSong> listSong;
    private OnItemClickListener listener;

    public ReListSongAdapter(Context context,
                             OnItemClickListener listener,
                             ArrayList<InfoSong> listSong) {
        this.context = context;
        this.listener = listener;
        this.listSong = listSong;
    }

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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view_music, parent, false);
        SongHolder songHolder = new SongHolder(view);
        return songHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final SongHolder songHolder = (SongHolder)holder;

        songHolder.populateData(listSong.get(position));
        songHolder.imgBtnOptionSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(songHolder.imgBtnOptionSong, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSong.size();
    }

    private static class SongHolder extends RecyclerView.ViewHolder {

        ImageView imgSong;
        TextView txtSongName;
        TextView txtInfo;
        ImageButton imgBtnOptionSong;

        public SongHolder(View itemView) {
            super(itemView);

            imgBtnOptionSong = (ImageButton)itemView.findViewById(R.id.imgBtnOptionSong);
            imgSong = (ImageView)itemView.findViewById(R.id.imgSong);
            txtSongName = (TextView)itemView.findViewById(R.id.txtSongName);
            txtInfo = (TextView)itemView.findViewById(R.id.txtInfoSong);
        }

        public void populateData(InfoSong infoSong) {

            txtSongName.setText(infoSong.getTitle());
            txtInfo.setText(infoSong.getInfoSong());
            LoadImage.loadImageSong(context, imgSong);
        }
    }
}
