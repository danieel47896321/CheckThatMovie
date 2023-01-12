package com.example.easytvshows.model

import com.google.gson.annotations.SerializedName

class TvShowModel {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("start_date")
    var startDate: String = ""

    @SerializedName("country")
    var country: String = ""

    @SerializedName("network")
    var network: String = ""

    @SerializedName("status")
    var status: String = ""

    @SerializedName("image_thumbnail_path")
    var image: String  = ""
}