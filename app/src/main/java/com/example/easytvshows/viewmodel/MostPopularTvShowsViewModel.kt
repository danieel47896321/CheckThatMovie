package com.example.easytvshows.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.easytvshows.repository.MostPopularTvShowsRepository
import com.example.easytvshows.response.TvShowResponse

class MostPopularTvShowsViewModel: ViewModel() {
    private var mostPopularTvShowsRepository = MostPopularTvShowsRepository()
    fun getMostPopularTvShows(page: Int): LiveData<TvShowResponse>{
        return mostPopularTvShowsRepository.getMostPopularTvShows(page)
    }
}