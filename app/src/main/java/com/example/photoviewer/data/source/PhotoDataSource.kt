package com.example.photoviewer.data.source

import com.example.photoviewer.photo.PhotoContract

interface PhotoDataSource {

    fun getPhoto(photoId: Int)

    fun setPresenter(presenter: PhotoContract.Presenter)
}