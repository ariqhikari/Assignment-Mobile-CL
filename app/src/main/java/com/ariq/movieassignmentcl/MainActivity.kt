package com.ariq.movieassignmentcl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ariq.movieassignmentcl.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList
import android.widget.Toast




class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by viewBinding()
    private val list = ArrayList<MovieResponse>()
    private lateinit var listMovieAdapter: ListMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.rvMovies.setHasFixedSize(true)

        RetrofitClient.instanse.getMovies().enqueue(object : Callback<ListMovieResponse> {
            override fun onResponse(
                call: Call<ListMovieResponse>,
                response: Response<ListMovieResponse>
            ) {
                val responseCode = response.code().toString()
                println(responseCode)
                (response.body() as ListMovieResponse).results.let { list.addAll(it) }

                showRecyclerViewList()
            }

            override fun onFailure(call: Call<ListMovieResponse>, t: Throwable) {
                println(t)
            }

        })
    }

    private fun showRecyclerViewList() {
        binding.apply {
            rvMovies.layoutManager = LinearLayoutManager(this@MainActivity)
            listMovieAdapter = ListMovieAdapter(list)
            rvMovies.adapter = listMovieAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }
}