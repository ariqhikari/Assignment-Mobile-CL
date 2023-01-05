package com.ariq.movieassignmentcl

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ariq.movieassignmentcl.databinding.ItemRowMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMovieAdapter(private val list : ArrayList<MovieResponse>) :
    RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {

        inner class ListViewHolder (private val binding : ItemRowMovieBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(movie: MovieResponse) {
                with(binding) {
                    tvMovieTitle.text = movie.title
                    tvMovieRate.text = movie.rate.toString()
                    tvMovieOverview.text = movie.overview
                    Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w500/" + movie.poster_path)
                        .apply(RequestOptions().override(300, 300))
                        .into(ivMovie)
                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_DETAIL, movie)
                        itemView.context.startActivity(intent)
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            val binding = ItemRowMovieBinding.inflate((LayoutInflater.from(parent.context)), parent, false)
            return ListViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val data = list[position]
            holder.bind(data)
        }

        override fun getItemCount(): Int {
            return list.size
        }
}