package com.example.photoviewer.mvp

import com.example.photoviewer.api.Album
import com.example.photoviewer.api.JsonPlaceHolderApi
import com.example.photoviewer.api.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPresenter(private val view: MainView, private val service: MainService) {

    fun getAlbumsList() {
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

                view.showAlbums(albums!!)
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                view.showApiError(t.message)
            }
        })
    }

    fun setAlbumIdForPhotos(albumId: Int) {
        view.setAlbumIdForPhotos(albumId)
    }

    fun getPhotosList(albumId: Int) {

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

                view.showPhotoTitles(photos!!)
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                view.showApiError(t.message)
            }
        })
    }

    fun setPhotosIdForPhoto(photoId: Int) {
        view.setPhotosIdForPhoto(photoId)
    }

    fun getPhoto(photoId: Int) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val call = jsonPlaceHolderApi.photo(photoId + 1)

        call.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photo: List<Photo>? = response.body()

                for (photoUrl in photo!!) {
                    view.showPhoto(photoUrl.url)
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                view.showApiError(t.message)
            }
        })
    }
}