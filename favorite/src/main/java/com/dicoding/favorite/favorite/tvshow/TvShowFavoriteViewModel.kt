package com.dicoding.favorite.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.model.Film
import com.dicoding.core.domain.usecase.FilmUseCase

class TvShowFavoriteViewModel(private val filmUseCase: FilmUseCase): ViewModel() {
    fun getTvShowFavorite(): LiveData<List<Film>> = filmUseCase.getFavoritedTvShow().asLiveData()

    fun setFavorite(film: Film) {
        val newState = !film.favorited
        filmUseCase.setFavoriteFilm(film, newState)
    }
}