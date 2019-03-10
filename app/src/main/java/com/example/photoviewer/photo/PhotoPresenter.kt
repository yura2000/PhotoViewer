package com.example.photoviewer.photo

import android.util.Log
import com.example.photoviewer.albums.AlbumsContract
import com.example.photoviewer.data.source.AlbumsDataSource
import com.example.photoviewer.data.source.PhotoDataSource

class PhotoPresenter(photoView: PhotoContract.View, photoData: PhotoDataSource): PhotoContract.Presenter {

    private var mPhotoRemoteDataSource: PhotoDataSource? = null

    private var mPhotoView: PhotoContract.View? = null

    private val TAG = "MyActivity"

    init {
        mPhotoView = photoView
        mPhotoRemoteDataSource = photoData

        mPhotoRemoteDataSource?.setPresenter(this)
        mPhotoView?.setPresenter(this)
    }


    override fun loadPhoto(photoUrl: String?) {
        mPhotoView?.showPhoto(photoUrl)
    }

    override fun getPhotos() {
        mPhotoRemoteDataSource?.getPhoto(4) //photoId here !!1
    }

    override fun showLoadError(resId: String?) {
        mPhotoView?.showLoadError(resId)
    }
}