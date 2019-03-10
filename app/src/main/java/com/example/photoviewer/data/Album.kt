package com.example.photoviewer.data

import android.view.View
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class Album {

    @SerializedName("userId")
    @Expose
    var userId: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null

}