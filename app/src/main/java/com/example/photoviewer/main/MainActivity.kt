package com.example.photoviewer.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

    private val albumFragment = AlbumsFragment()
    private val concreteAlbumFragment = ConcreteAlbumFragment()
    private val photoFragment = PhotoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.photoviewer.R.layout.main_activity)
        startAlbumsFragment()
    }

    override fun startAlbumsFragment() {

        val repository = AlbumsRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .add(com.example.photoviewer.R.id.main_frag, albumFragment)
            .commit()

        val presenter = AlbumsPresenter(albumFragment, repository)
    }

    override fun startConcreteAlbumFragment(itemId: Int) {
        val arg = Bundle()
        arg.putInt("ID", itemId)

        concreteAlbumFragment.arguments = arg

        val repository = PhotosRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .add(com.example.photoviewer.R.id.main_frag, concreteAlbumFragment)
            .show(concreteAlbumFragment)
            .hide(albumFragment)
            .addToBackStack(null)
            .commit()

        val presenter = ConcreteAlbumPresenter(concreteAlbumFragment, repository)
    }

    override fun startPhotoFragment(itemId: Int) {
        val arg = Bundle()
        arg.putInt("PHOTO_ID", itemId)

        photoFragment.arguments = arg

        val repository = PhotoRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .add(com.example.photoviewer.R.id.main_frag, photoFragment)
            .show(photoFragment)
            .hide(concreteAlbumFragment)
            .addToBackStack(null)
            .commit()

        val presenter = PhotoPresenter(photoFragment, repository)
    }

    override fun onConcreteAlbumClicked(item: Photo) {
        item.id?.let { startPhotoFragment(it) }
    }

    override fun onAlbumsClicked(item: Album) {
        item.id?.let { startConcreteAlbumFragment(it) }
    }
}
