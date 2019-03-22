package com.example.photoviewer.albums

import android.view.View
import com.example.photoviewer.data.Album

interface AlbumsClickListener{
    fun onAlbumsClicked(item: Album)
}