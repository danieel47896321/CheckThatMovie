package com.example.easytvshows

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SelectedMovie : AppCompatActivity() {
    private lateinit var title: TextView
    private lateinit var backIcon: ImageView
    //private lateinit var movie: Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_movie)
        init()
    }
    private fun init() {
        /*movie = (intent.getSerializableExtra("movie") as? Movie)!!
        title = findViewById<TextView>(R.id.title)
        title.text = resources.getText(R.string.SelectedMovie)*/
        backIcon = findViewById<ImageView>(R.id.backIcon)
        setBackIcon()
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