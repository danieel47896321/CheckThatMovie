package com.example.easytvshows.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easytvshows.R
import com.example.easytvshows.SelectedTvShow
import com.example.easytvshows.model.TvShowModel

class TvShowAdapter (noteList: ArrayList<TvShowModel>) : RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {
    private var list = ArrayList<TvShowModel>()
    init { list = noteList }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_view, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: TvShowAdapter.ViewHolder, position: Int) {
        holder.textViewMovieName.text = list[position].name
        holder.textViewDate.text = list[position].startDate
        Glide.with(holder.itemView).load(list[position].image).into(holder.imageViewMovie)
        holder.linearLayout.setOnClickListener{
            val intent = Intent(holder.itemView.context, SelectedTvShow::class.java)
            intent.putExtra("SelectedTvShowName", list[position].name)
            intent.putExtra("SelectedTvShowImage", list[position].image)
            intent.putExtra("SelectedTvShowStartDate", list[position].startDate)
            intent.putExtra("SelectedTvShowNetwork", list[position].network)
            intent.putExtra("SelectedTvShowCountry", list[position].country)
            intent.putExtra("SelectedTvShowStatus", list[position].status)
            holder.itemView.context.startActivity(intent)
            (holder.itemView.context as Activity).finish()
        }
    }
    override fun getItemCount(): Int { return list.size }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewMovieName: TextView
        var textViewDate: TextView
        var imageViewMovie: ImageView
        var linearLayout :LinearLayout
        init {
            textViewMovieName = view.findViewById(R.id.textViewTvShowName)
            textViewDate = view.findViewById(R.id.textViewDate)
            imageViewMovie = view.findViewById(R.id.imageViewMovie)
            linearLayout = view.findViewById(R.id.linearLayout)
        }
    }
}