package com.example.photoviewer.api

import retrofit2.http.GET
import retrofit2.Call;

interface JsonPlaceHolderApi {

    @get:GET("albums")
    val albums: Call<List<Album>>
}