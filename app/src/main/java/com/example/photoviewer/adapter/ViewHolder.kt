package com.example.photoviewer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.photoviewer.R
import com.example.photoviewer.api.Album
import kotlinx.android.synthetic.main.item_title.view.*

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var albumTitle: TextView? = null
    var albumId: TextView? = null

    init {
        albumTitle = itemView?.findViewById(R.id.albumTitle_tv)
        albumId = itemView?.findViewById(R.id.albumId_tv)
    }

    fun bind(album: Album) {
        albumTitle?.text = album.title
        albumId?.text = album.id.toString()
    }
}