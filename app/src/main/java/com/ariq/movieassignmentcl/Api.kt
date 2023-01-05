package com.ariq.movieassignmentcl

import com.google.gson.internal.LinkedTreeMap
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("discover/movie?api_key=453268eaaa2df0767cd8d339fa4a431d")
    fun getMovies(): Call<ListMovieResponse>
}