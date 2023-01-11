package com.example.easytvshows.network

import com.example.easytvshows.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("most-popular")
    fun getMostPopularTvShows(@Query("page") page: Int): Call<TvShowResponse>
}