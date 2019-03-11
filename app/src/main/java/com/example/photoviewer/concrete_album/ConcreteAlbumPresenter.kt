package com.example.photoviewer.concrete_album

import com.example.photoviewer.data.Photo
import com.example.photoviewer.data.source.PhotosDataSource

class ConcreteAlbumPresenter(concreteAlbumView: ConcreteAlbumContract.View, concreteAlbumData: PhotosDataSource, albumId: Int?)
    : ConcreteAlbumContract.Presenter {

    private var mPhotosRemoteDataSource: PhotosDataSource? = null

    private var mConcreteAlbumView: ConcreteAlbumContract.View? = null

    private var albumsId: Int? = albumId

    init {
        mConcreteAlbumView = concreteAlbumView
        mPhotosRemoteDataSource = concreteAlbumData

        mPhotosRemoteDataSource?.setPresenter(this)
        mConcreteAlbumView?.setPresenter(this)
    }

    override fun loadPhotos(photos: List<Photo>?) {
        mConcreteAlbumView?.showPhotos(photos)
    }

    override fun getPhotos() {
        mPhotosRemoteDataSource?.getPhotos(albumsId)
    }

    override fun showLoadError(resId: String?) {
        mConcreteAlbumView?.showLoadError(resId)
    }

    override fun onConcreteAlbumSelected(photo: Photo?) {
        mConcreteAlbumView?.showPhotoActivity(photo?.id)
    }
}