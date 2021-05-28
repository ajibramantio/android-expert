package com.dicoding.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.*
import com.dicoding.core.data.source.remote.response.GenreResponse
import com.dicoding.core.utils.DataConverter

@Entity(tableName = "filmentities")
data class FilmEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @TypeConverters(DataConverter::class)
    @ColumnInfo(name = "genre")
    var genre:  ArrayList<GenreResponse>,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "imdbScore")
    var imdbScore: Double,

    @ColumnInfo(name = "releaseYear")
    var releaseYear: String,

    @ColumnInfo(name = "duration")
    var duration:Int,

    @ColumnInfo(name = "photo")
    var photo:String,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false,

    @ColumnInfo(name = "type")
    var type: String
)