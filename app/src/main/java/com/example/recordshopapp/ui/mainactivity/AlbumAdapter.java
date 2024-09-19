package com.example.recordshopapp.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.databinding.AlbumItemsBinding;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private List<Album> albumList;
    private Context context;

    public AlbumAdapter(List<Album> albumList, Context context) {
        this.albumList = albumList;
        this.context = context;
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private final AlbumItemsBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemsBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AlbumItemsBinding binding = AlbumItemsBinding.inflate(inflater, parent, false);
        return new AlbumViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.albumItemBinding.setAlbum(album);
        holder.albumItemBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
