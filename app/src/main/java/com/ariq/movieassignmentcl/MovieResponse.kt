package com.ariq.movieassignmentcl

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    val id : Int,
    val title : String,
    val poster_path : String,
    val backdrop_path : String,
    val overview : String,

    @SerializedName("vote_average")
    val rate : Float,
) : Parcelable
