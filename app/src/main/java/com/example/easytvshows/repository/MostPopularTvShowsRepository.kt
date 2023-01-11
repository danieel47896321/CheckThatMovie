package com.example.easytvshows.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.easytvshows.network.ApiClient
import com.example.easytvshows.network.ApiService
import com.example.easytvshows.response.TvShowResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MostPopularTvShowsRepository {
    private var apiService: ApiService = ApiClient.getRetrofit()?.create(ApiService::class.java)!!
    fun getMostPopularTvShows(page: Int): LiveData<TvShowResponse>{
        val data: MutableLiveData<TvShowResponse> = MutableLiveData()
        apiService.getMostPopularTvShows(page).enqueue(object: Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                data.value = response.body()
            }
            override fun onFailure(call: Call<TvShowResponse?>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}