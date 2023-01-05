package com.ariq.movieassignmentcl

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
    @SerializedName("results")
    val results: List<MovieResponse>
)
