package com.dicoding.core.data.source.local.room

import androidx.room.*
import com.dicoding.core.data.source.local.entity.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Query("SELECT * FROM filmentities where type='film' ")
    fun getFilm(): Flow<List<FilmEntity>>

    @Query("SELECT * FROM filmentities where type='film' and favorited = 1")
    fun getFavoritedFilm():  Flow<List<FilmEntity>>

    @Query("SELECT * FROM filmentities where type='tvshow' ")
    fun getTvShow():  Flow<List<FilmEntity>>

    @Query("SELECT * FROM filmentities where type='tvshow' and favorited = 1")
    fun getFavoritedTvShow(): Flow<List<FilmEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(films: List<FilmEntity>)

    @Update
    fun updateFilm(film: FilmEntity)

    @Query("SELECT * FROM filmentities WHERE id = :filmId")
    fun getDetail(filmId: Int): Flow<FilmEntity>
}