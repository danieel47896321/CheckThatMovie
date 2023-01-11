package com.example.easytvshows.response

import com.example.easytvshows.model.TvShowModel
import com.google.gson.annotations.SerializedName

class TvShowResponse {
    @SerializedName("page")
    lateinit var page: Integer

    @SerializedName("pages")
    lateinit var totalPages: String

    @SerializedName("tv_shows")
    lateinit var tvShows: ArrayList<TvShowModel>
}