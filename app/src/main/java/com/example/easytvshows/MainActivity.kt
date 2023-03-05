package com.example.easytvshows

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.easytvshows.adapter.TvShowAdapter
import com.example.easytvshows.model.TvShowModel
import com.example.easytvshows.viewmodel.MostPopularTvShowsViewModel
class MainActivity : AppCompatActivity() {
    private lateinit var mostPopularTvShowsViewModel: MostPopularTvShowsViewModel
    private lateinit var title: TextView
    private lateinit var backIcon: ImageView
    private lateinit var recyclerView : RecyclerView
    private lateinit var progressBar: ProgressBar
    private var currentPage = 1
    private var totalPages: Int = 1
    private var movieList = ArrayList<TvShowModel>()
    private var tvShowAdapter = TvShowAdapter(movieList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        mostPopularTvShowsViewModel = ViewModelProvider(this)[MostPopularTvShowsViewModel::class.java]
        title = findViewById<TextView>(R.id.title)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        backIcon = findViewById<ImageView>(R.id.backIcon)
        backIcon.visibility = View.GONE
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = tvShowAdapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (recyclerView.canScrollVertically(1)) {
                    if (currentPage <= totalPages) {
                        currentPage++
                        getMovies()
                    }
                }
            }
        })
        getMovies()

    }
    private fun getMovies() {
        mostPopularTvShowsViewModel.getMostPopularTvShows(currentPage).observe(this) { mostPopularTvShows ->
            val currentSize = movieList.size
            progressBar.visibility = View.GONE
            if (mostPopularTvShows != null) {
                totalPages = mostPopularTvShows.totalPages
                if (mostPopularTvShows.tvShows != null) {
                    movieList.addAll(mostPopularTvShows.tvShows)
                    tvShowAdapter.notifyItemRangeInserted(currentSize, movieList.size)
                }
            }
        }
    }
}