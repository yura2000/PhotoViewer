package com.example.photoviewer.albums

import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.photoviewer.data.Album
import com.example.photoviewer.data.source.AlbumsDataSource
import com.example.photoviewer.data.source.remote.AlbumsRemoteDataSource
import java.util.ArrayList

class AlbumsPresenter(albumsView: AlbumsContract.View, albumsData: AlbumsDataSource) : AlbumsContract.Presenter,
    View.OnClickListener {

    private var mAlbumsRemoteDataSource: AlbumsDataSource? = null

    private var mAlbumsView: AlbumsContract.View? = null


    init {
        mAlbumsView = albumsView
        mAlbumsRemoteDataSource = albumsData

        mAlbumsRemoteDataSource?.setPresenter(this)
        mAlbumsView?.setPresenter(this)
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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