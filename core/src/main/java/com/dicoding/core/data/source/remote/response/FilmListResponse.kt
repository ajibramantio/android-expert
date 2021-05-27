package com.dicoding.core.data.source.remote.response

import android.os.Parcelable
import com.dicoding.core.data.source.remote.response.FilmDetailResponse
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmListResponse (

    @field:SerializedName("results")
    var allFilm: ArrayList<FilmDetailResponse>,
):Parcelable
