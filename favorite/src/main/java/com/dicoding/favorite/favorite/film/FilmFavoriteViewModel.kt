package com.dicoding.favorite.favorite.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.model.Film
import com.dicoding.core.domain.usecase.FilmUseCase

class FilmFavoriteViewModel(private val filmUseCase: FilmUseCase): ViewModel() {
    fun getFavoriteFilm(): LiveData<List<Film>> = filmUseCase.getFavoritedFilm().asLiveData()

    fun setFavorite(film: Film) {
        val newState = !film.favorited
        filmUseCase.setFavoriteFilm(film, newState)
    }
}