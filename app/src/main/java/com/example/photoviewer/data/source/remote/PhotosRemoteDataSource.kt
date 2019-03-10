package com.example.photoviewer.data.source.remote

import com.example.photoviewer.albums.AlbumsContract
import com.example.photoviewer.concrete_album.ConcreteAlbumContract
import com.example.photoviewer.concrete_album.ConcreteAlbumPresenter
import com.example.photoviewer.data.Photo
import com.example.photoviewer.data.source.PhotosDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotosRemoteDataSource: PhotosDataSource {

    private var mPresenter: ConcreteAlbumContract.Presenter? = null

    override fun getPhotos(albumId: Int) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val call = jsonPlaceHolderApi.photos(albumId)

        var photos: List<Photo>?

        call.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                photos = response.body()

                mPresenter?.loadPhotos(photos)

            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                mPresenter?.showLoadError(t.message)
            }
        })    }

    override fun setPresenter(presenter: ConcreteAlbumContract.Presenter) {
        mPresenter = presenter
    }

}