package com.dicoding.core.domain.repository

import com.dicoding.core.domain.model.Film
import com.dicoding.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IFilmRepository {
    fun getAllFilm(): Flow<Resource<List<Film>>>

    fun getAllTvShow(): Flow<Resource<List<Film>>>

    fun getDetailFilm(id: Int):Flow<Resource<Film>>

    fun getDetailTv(id:Int):Flow<Resource<Film>>

    fun getFavoritedFilm(): Flow<List<Film>>

    fun getFavoritedTvShow(): Flow<List<Film>>

    fun setFavoriteFilm(film: Film, state: Boolean)

    fun setFavoriteTvShow(tv: Film, state: Boolean)

}