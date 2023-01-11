package com.example.easytvshows.model

import com.google.gson.annotations.SerializedName

class TvShowModel {
    @SerializedName("id")
    lateinit var id: Integer

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("start_date")
    lateinit var startDate: String

    @SerializedName("country")
    lateinit var country: String

    @SerializedName("network")
    lateinit var network: String

    @SerializedName("status")
    lateinit var status: String

    @SerializedName("image_thumbnail_path")
    lateinit var image: String
}