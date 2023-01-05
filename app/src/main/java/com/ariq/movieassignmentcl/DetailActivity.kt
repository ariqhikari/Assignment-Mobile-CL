package com.ariq.movieassignmentcl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ariq.movieassignmentcl.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
    private val binding : ActivityDetailBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setContentView(binding.root)

        supportActionBar?.title = "Detail Movie"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setData()
    }

    private fun setData() {
        binding.apply {
            val movie = intent.getParcelableExtra<MovieResponse>(EXTRA_DETAIL)

            tvMovieTitle.text = movie?.title
            tvMovieRate.text = movie?.rate.toString()
            tvMovieOverview.text = movie?.overview

            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500/" + movie?.backdrop_path)
                .apply(RequestOptions())
                .into(ivMovie)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }
}