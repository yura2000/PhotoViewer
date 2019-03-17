package com.example.photoviewer.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.photoviewer.R
import com.example.photoviewer.albums.AlbumsClickListener
import com.example.photoviewer.albums.AlbumsFragment
import com.example.photoviewer.albums.AlbumsPresenter
import com.example.photoviewer.concrete_album.ConcreteAlbumClickListener
import com.example.photoviewer.concrete_album.ConcreteAlbumFragment
import com.example.photoviewer.concrete_album.ConcreteAlbumPresenter
import com.example.photoviewer.data.Album
import com.example.photoviewer.data.Photo
import com.example.photoviewer.data.source.remote.AlbumsRemoteDataSource
import com.example.photoviewer.data.source.remote.PhotoRemoteDataSource
import com.example.photoviewer.data.source.remote.PhotosRemoteDataSource
import com.example.photoviewer.photo.PhotoFragment
import com.example.photoviewer.photo.PhotoPresenter

class MainActivity : AppCompatActivity(), MainScreenContract.View, ConcreteAlbumClickListener, AlbumsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        startAlbumsFragment()
    }

    override fun startAlbumsFragment() {
        val fragment = AlbumsFragment()

        val repository = AlbumsRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .replace(com.example.photoviewer.R.id.main_frag, fragment)
            .commit()

        val presenter = AlbumsPresenter(fragment, repository)
    }

    override fun startConcreteAlbumFragment() {
        val fragment = ConcreteAlbumFragment()

        val repository = PhotosRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .replace(com.example.photoviewer.R.id.main_frag, fragment)
            .addToBackStack(null)
            .commit()

        val presenter = ConcreteAlbumPresenter(fragment, repository)
    }

    override fun startPhotoFragment() {
        val fragment = PhotoFragment()

        val repository = PhotoRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .replace(com.example.photoviewer.R.id.main_frag, fragment)
            .addToBackStack(null)
            .commit()

        val presenter = PhotoPresenter(fragment, repository)
    }

    override fun onConcreteAlbumClicked(view: View, item: Photo) {
        val arg: Bundle? = null
        arg?.putInt("PHOTO_ID", item.id!!)
        startPhotoFragment()
    }

    override fun onAlbumsClicked(view: View, item: Album) {
        val arg: Bundle? = null
        arg?.putInt("ALBUM_ID", item.id!!)
        startConcreteAlbumFragment()
    }
}
