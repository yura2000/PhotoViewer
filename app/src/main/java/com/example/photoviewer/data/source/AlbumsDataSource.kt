package com.example.photoviewer.data.source

import com.example.photoviewer.albums.AlbumsContract
import com.example.photoviewer.data.Album

interface AlbumsDataSource {

    fun getAlbums()

    fun setPresenter(presenter: AlbumsContract.Presenter)

}