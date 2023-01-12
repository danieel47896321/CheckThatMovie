package com.example.easytvshows.response

import com.example.easytvshows.model.TvShowModel
import com.google.gson.annotations.SerializedName

class TvShowResponse {
    @SerializedName("page")
    var page: Int = 0

    @SerializedName("pages")
    var totalPages: Int  = 0

    @SerializedName("tv_shows")
    lateinit var tvShows: ArrayList<TvShowModel>
}