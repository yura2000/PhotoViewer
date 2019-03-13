package com.example.photoviewer.concrete_album

import android.view.View
import com.example.photoviewer.data.Photo

interface ConcreteAlbumClickListener {
    fun onConcreteAlbumClicked(view: View, item: Photo)
}