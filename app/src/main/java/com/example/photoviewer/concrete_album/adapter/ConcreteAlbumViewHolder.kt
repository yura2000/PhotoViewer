package com.example.photoviewer.concrete_album.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.photoviewer.R
import com.example.photoviewer.concrete_album.ConcreteAlbumClickListener
import com.example.photoviewer.data.Photo

class ConcreteAlbumViewHolder(itemView: View, val onClickItem: ConcreteAlbumClickListener?) : RecyclerView.ViewHolder(itemView) {
    var photoTitle: TextView? = null
    var photoId: TextView? = null
    var containItem: ConstraintLayout? = null

    init {
        photoTitle = itemView.findViewById(com.example.photoviewer.R.id.itemTitle_tv)
        photoId = itemView.findViewById(com.example.photoviewer.R.id.itemId_tv)
        containItem = itemView.findViewById(R.id.containerItem)
    }

    fun bind(photo: Photo) {
        photoTitle?.text = photo.title
        photoId?.text = photo.id.toString()
        containItem?.setOnClickListener{ v ->
            onClickItem?.onConcreteAlbumClicked(v, photo)
        }
    }
}