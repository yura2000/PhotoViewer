package com.example.photoviewer.albums

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.photoviewer.data.Album
import com.example.photoviewer.main.MainPresenter

class AlbumsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
    var albumTitle: TextView? = null
    var albumId: TextView? = null

    init {
        albumTitle = itemView.findViewById(com.example.photoviewer.R.id.itemTitle_tv)
        albumId = itemView.findViewById(com.example.photoviewer.R.id.itemId_tv)
    }

    override fun onClick(v: View?) {
        //presenter?.setAlbumIdForPhotos(adapterPosition)
    }

    fun bind(album: Album) {
        albumTitle?.text = album.title
        albumId?.text = album.id.toString()
        itemView.setOnClickListener(this)
    }
}