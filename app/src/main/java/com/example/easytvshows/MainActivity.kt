package com.example.easytvshows

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.easytvshows.adapter.MovieAdapter
import com.example.easytvshows.model.TvShowModel
import com.example.easytvshows.viewmodel.MostPopularTvShowsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mostPopularTvShowsViewModel: MostPopularTvShowsViewModel
    private lateinit var title: TextView
    private lateinit var backIcon: ImageView
    private lateinit var recyclerView : RecyclerView
    private lateinit var progressBar: ProgressBar
    private var movieList = ArrayList<TvShowModel>()
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
        getMovies()
    }
    private fun getMovies() {
        mostPopularTvShowsViewModel.getMostPopularTvShows(0).observe(this) { most ->
            movieList.addAll(most.tvShows)
            progressBar.visibility = View.GONE
            setMovies()
        }
    }
    private fun setMovies() {
        val movieAdapter = MovieAdapter(movieList)
        recyclerView.adapter = movieAdapter
    }
}