package com.dicoding.core.data.source.local

import com.dicoding.core.data.source.local.entity.FilmEntity
import com.dicoding.core.data.source.local.room.FilmDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mFilmDao: FilmDao) {
    fun getAllFilm(): Flow<List<FilmEntity>> = mFilmDao.getFilm()
    fun getAllTvShow():  Flow<List<FilmEntity>> = mFilmDao.getTvShow()

    fun getFavoritedFilm(): Flow<List<FilmEntity>> = mFilmDao.getFavoritedFilm()
    fun getFavoritedTvShow():  Flow<List<FilmEntity>> = mFilmDao.getFavoritedTvShow()

    fun getDetailFilm(filmId: Int): Flow<FilmEntity> = mFilmDao.getDetail(filmId)

    fun insertFilm(films: List<FilmEntity>) = mFilmDao.insertFilm(films)

    fun updateFilm(film: FilmEntity) {
        mFilmDao.updateFilm(film)
    }

    fun setFilmFavorite(film: FilmEntity, newState: Boolean) {
        film.favorited = newState
        mFilmDao.updateFilm(film)
    }


}