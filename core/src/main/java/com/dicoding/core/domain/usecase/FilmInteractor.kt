package com.dicoding.core.domain.usecase

import com.dicoding.core.domain.model.Film
import com.dicoding.core.domain.repository.IFilmRepository
import com.dicoding.core.vo.Resource
import kotlinx.coroutines.flow.Flow

class FilmInteractor(private val filmRepository: IFilmRepository): FilmUseCase {
    override fun getAllFilm(): Flow<Resource<List<Film>>> {
        return filmRepository.getAllFilm()
    }

    override fun getAllTvShow(): Flow<Resource<List<Film>>> {
        return filmRepository.getAllTvShow()
    }

    override fun getDetailFilm(id: Int): Flow<Resource<Film>> {
        return filmRepository.getDetailFilm(id)
    }

    override fun getDetailTv(id: Int): Flow<Resource<Film>> {
       return filmRepository.getDetailTv(id)
    }

    override fun getFavoritedFilm(): Flow<List<Film>> {
       return filmRepository.getFavoritedFilm()
    }

    override fun getFavoritedTvShow(): Flow<List<Film>> {
        return filmRepository.getFavoritedTvShow()
    }

    override fun setFavoriteFilm(film: Film, state: Boolean) {
        return filmRepository.setFavoriteFilm(film, state)
    }

    override fun setFavoriteTvShow(tv: Film, state: Boolean) {
        return filmRepository.setFavoriteTvShow(tv, state)
    }

}