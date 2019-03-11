package com.example.photoviewer.albums

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.photoviewer.data.Album
import com.example.photoviewer.main.MainPresenter


class AlbumsRecyclerAdapter(private val values: List<Album>) : RecyclerView.Adapter<AlbumsViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AlbumsViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(com.example.photoviewer.R.layout.item_title, p0, false)
        return AlbumsViewHolder(itemView)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holderAlbums: AlbumsViewHolder, pos: Int) {
        val album: Album = values[pos]
        holderAlbums.bind(album)
    }
}
