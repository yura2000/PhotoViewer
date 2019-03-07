package com.example.photoviewer.mvp

import android.support.v7.widget.RecyclerView

interface MainView {
    val albumsRecyclerView: RecyclerView

    fun showAlbums()

    fun showApiError(resId: String?)
}
