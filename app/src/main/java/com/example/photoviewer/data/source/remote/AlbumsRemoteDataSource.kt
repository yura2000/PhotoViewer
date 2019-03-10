package com.example.photoviewer.data.source.remote

import android.util.Log
import com.example.photoviewer.albums.AlbumsContract
import com.example.photoviewer.data.Album
import com.example.photoviewer.data.source.AlbumsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumsRemoteDataSource : AlbumsDataSource {

    private var mPresenter: AlbumsContract.Presenter? = null

    private val TAG = "MyActivity"

    override fun setPresenter(presenter: AlbumsContract.Presenter) {
        mPresenter = presenter
    }

    override fun getAlbums() {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val call = jsonPlaceHolderApi.albums

        var albums: List<Album>?

        call.enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albums = response.body()

                mPresenter?.loadAlbums(albums)
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                mPresenter?.showLoadError(t.message)
            }
        })
    }

}