package com.example.photoviewer.data.source.remote

import com.example.photoviewer.data.Photo
import com.example.photoviewer.data.source.PhotoDataSource
import com.example.photoviewer.photo.PhotoContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoRemoteDataSource: PhotoDataSource {

    private var mPresenter: PhotoContract.Presenter? = null

    override fun getPhoto(photoId: Int?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val call = jsonPlaceHolderApi.photo(photoId)

        call.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photo: List<Photo>? = response.body()

                for (photoUrl in photo!!) {
                    mPresenter?.loadPhoto(photoUrl.url)
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                mPresenter?.showLoadError(t.message)
            }
        })
    }

    override fun setPresenter(presenter: PhotoContract.Presenter) {
        mPresenter = presenter
    }
}