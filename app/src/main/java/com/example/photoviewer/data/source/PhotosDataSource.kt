package com.example.photoviewer.data.source

import com.example.photoviewer.concrete_album.ConcreteAlbumContract

interface PhotosDataSource {

    fun getPhotos(albumId: Int?)

    fun setPresenter(presenter: ConcreteAlbumContract.Presenter)

}