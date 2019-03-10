package com.example.photoviewer.concrete_album

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.photoviewer.data.Photo
import com.example.photoviewer.main.MainPresenter

class ConcreteAlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var photoTitle: TextView? = null
    var photoId: TextView? = null

    init {
        photoTitle = itemView.findViewById(com.example.photoviewer.R.id.itemTitle_tv)
        photoId = itemView.findViewById(com.example.photoviewer.R.id.itemId_tv)
    }

    fun bind(photo: Photo) {
        photoTitle?.text = photo.title
        photoId?.text = photo.id.toString()
    }
}