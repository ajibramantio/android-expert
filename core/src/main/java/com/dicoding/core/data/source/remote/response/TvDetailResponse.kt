package com.dicoding.core.data.source.remote.response

import android.os.Parcelable
import com.dicoding.core.data.source.remote.response.GenreResponse
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvDetailResponse(

    @field:SerializedName("id")
    var id: Int,

    @field:SerializedName("name")
    var title: String? = "",

    @field:SerializedName("genres")
    var genre: ArrayList<GenreResponse> = ArrayList<GenreResponse>(),

    @field:SerializedName("overview")
    var overview: String ="",

    @field:SerializedName("imdb_average")
    var imdbScore: Double = 0.0,

    @field:SerializedName("first_air_date")
    var releaseYear: String?="",

    @field:SerializedName("runtime")
    var duration:Int? =0,

    @field:SerializedName("poster_path")
    var photo:String
): Parcelable
