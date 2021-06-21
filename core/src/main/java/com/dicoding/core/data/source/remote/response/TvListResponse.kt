package com.dicoding.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvListResponse (

    @field:SerializedName("results")
    var allFilm: ArrayList<TvDetailResponse>,
):Parcelable
