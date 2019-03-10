package com.example.photoviewer.data.source.remote

import com.example.photoviewer.data.Album
import com.example.photoviewer.data.Photo
import retrofit2.http.GET
import retrofit2.Call;
import retrofit2.http.Query

interface JsonPlaceHolderApi {

    @get:GET("albums")
    val albums: Call<List<Album>>

    @GET("photos")
    fun photos(@Query("albumId") userId: Int?): Call<List<Photo>>

    @GET("photos")
    fun photo(@Query("id") userId: Int?): Call<List<Photo>>
}