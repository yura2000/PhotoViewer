package com.example.photoviewer.albums

import android.view.View
import com.example.photoviewer.albums.adapter.AlbumsRecyclerAdapter
import com.example.photoviewer.data.Album
import com.example.photoviewer.data.source.AlbumsDataSource

class AlbumsPresenter(albumsView: AlbumsContract.View, albumsData: AlbumsDataSource) : AlbumsContract.Presenter{

    private var mAlbumsRemoteDataSource: AlbumsDataSource? = null

    private var mAlbumsView: AlbumsContract.View? = null


    init {
        mAlbumsView = albumsView
        mAlbumsRemoteDataSource = albumsData

        mAlbumsRemoteDataSource?.setPresenter(this)
        mAlbumsView?.setPresenter(this)
    }

    override fun loadAlbums(albums: List<Album>?) {
        mAlbumsView?.showAlbums(albums)
    }

    override fun getAlbums() {
        mAlbumsRemoteDataSource?.getAlbums()
    }

    override fun showLoadError(resId: String?) {
        mAlbumsView?.showLoadError(resId)
    }

}