package com.example.photoviewer.albums.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.photoviewer.R
import com.example.photoviewer.albums.AlbumsClickListener
import com.example.photoviewer.data.Album

class AlbumsViewHolder(itemView: View, private val onClickItem: AlbumsClickListener?) : RecyclerView.ViewHolder(itemView) {
    var albumTitle: TextView? = null
    var albumId: TextView? = null
    var containItem: ConstraintLayout? = null

    init {
        albumTitle = itemView.findViewById(com.example.photoviewer.R.id.itemTitle_tv)
        albumId = itemView.findViewById(com.example.photoviewer.R.id.itemId_tv)
        containItem = itemView.findViewById(R.id.containerItem)
    }

    fun bind(album: Album) {
        albumTitle?.text = album.title
        albumId?.text = album.id.toString()
        containItem?.setOnClickListener{ v ->
            onClickItem?.onAlbumsClicked(v, album)
        }
    }
}