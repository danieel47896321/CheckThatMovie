package com.example.easytvshows

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SelectedTvShow : AppCompatActivity() {
    private lateinit var title: TextView
    private lateinit var textViewMovieName: TextView
    private lateinit var textViewMovieStartDate: TextView
    private lateinit var textViewMovieNetwork: TextView
    private lateinit var textViewMovieCountry: TextView
    private lateinit var textViewMovieStatus: TextView
    private lateinit var backIcon: ImageView
    private lateinit var imageViewMovieImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_movie)
        init()
    }
    private fun init() {
        val movieName = intent.getStringExtra("SelectedTvShowName")
        val movieImage = intent.getStringExtra("SelectedTvShowImage")
        val movieStartDate = intent.getStringExtra("SelectedTvShowStartDate")
        val movieNetwork = intent.getStringExtra("SelectedTvShowNetwork")
        val movieCountry = intent.getStringExtra("SelectedTvShowCountry")
        val movieStatus = intent.getStringExtra("SelectedTvShowStatus")
        title = findViewById<TextView>(R.id.title)
        textViewMovieName = findViewById<TextView>(R.id.textViewTvShowName)
        textViewMovieStartDate = findViewById<TextView>(R.id.textViewTvShowStartDate)
        textViewMovieNetwork = findViewById<TextView>(R.id.textViewTvShowNetwork)
        textViewMovieCountry = findViewById<TextView>(R.id.textViewTvShowCountry)
        textViewMovieStatus = findViewById<TextView>(R.id.textViewTvShowStatus)
        backIcon = findViewById<ImageView>(R.id.backIcon)
        imageViewMovieImage = findViewById<ImageView>(R.id.imageViewMovieImage)
        title.text = movieName
        setViewInfo("Tv Show Name: $movieName", "Start Date: $movieStartDate", "Network: $movieNetwork", "Country: $movieCountry", "Status: $movieStatus", movieImage)
        setBackIcon()
    }
    private fun setViewInfo(movieName: String, movieStartDate: String, movieNetwork: String, movieCountry: String, movieStatus: String, movieImage: String?) {
        textViewMovieName.text = movieName
        textViewMovieStartDate.text = movieStartDate
        textViewMovieNetwork.text = movieNetwork
        textViewMovieCountry.text = movieCountry
        textViewMovieStatus.text = movieStatus
        Glide.with(this).load(movieImage).into(imageViewMovieImage)
    }
    private fun setBackIcon() {
        backIcon.setOnClickListener{
            onBackPressed()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity :: class.java))
        finish()
    }
}