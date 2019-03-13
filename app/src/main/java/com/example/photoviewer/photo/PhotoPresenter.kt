package com.example.photoviewer.photo

import com.example.photoviewer.data.source.PhotoDataSource

class PhotoPresenter(photoView: PhotoContract.View, photoData: PhotoDataSource) : PhotoContract.Presenter {

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

    override fun getPhotos(photoId: Int?) {
        mPhotoRemoteDataSource?.getPhoto(photoId) //photoId here !!1
    }

    override fun showLoadError(resId: String?) {
        mPhotoView?.showLoadError(resId)
    }
}