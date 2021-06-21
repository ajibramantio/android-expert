package com.dicoding.core.domain.model

import android.os.Parcelable
import com.dicoding.core.data.source.remote.response.GenreResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    var id: Int,
    var title: String,
    var genre:  ArrayList<GenreResponse>,
    var overview: String,
    var imdbScore: Double,
    var releaseYear: String,
    var duration:Int,
    var photo:String,
    var favorited: Boolean = false,
    var type: String
) : Parcelable