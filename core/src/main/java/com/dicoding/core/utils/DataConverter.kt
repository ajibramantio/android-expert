package com.dicoding.core.utils

import androidx.room.TypeConverter
import com.dicoding.core.data.source.remote.response.GenreResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type


class DataConverter:Serializable {
    @TypeConverter
    fun fromGenreList(genreValues: ArrayList<GenreResponse?>?): String? {
        if (genreValues == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<ArrayList<GenreResponse?>?>() {}.getType()
        return gson.toJson(genreValues, type)
    }

    @TypeConverter
    fun toGenreList(genreValuesString: String?): ArrayList<GenreResponse>? {
        if (genreValuesString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<ArrayList<GenreResponse?>?>() {}.getType()
        return gson.fromJson<ArrayList<GenreResponse>>(genreValuesString, type)
    }
}