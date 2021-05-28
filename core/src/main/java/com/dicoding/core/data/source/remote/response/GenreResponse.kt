package com.dicoding.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreResponse(

    @field:SerializedName("id")
    var id: Int,

    @field:SerializedName("name")
    var name: String? = "",
): Parcelable