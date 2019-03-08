package com.example.photoviewer.api

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