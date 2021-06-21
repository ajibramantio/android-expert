package com.dicoding.myfavoriteapp.ui.detail

import androidx.lifecycle.*
import com.dicoding.core.domain.model.Film
import com.dicoding.core.domain.usecase.FilmUseCase
import com.dicoding.core.vo.Resource

class DetailFilmViewModel(private val filmUseCase: FilmUseCase): ViewModel() {
    private val filmId = MutableLiveData<Int>()

    fun setSelectedFilm(filmId: Int) {
        this.filmId.value = filmId
    }

    var getFilm: LiveData<Resource<Film>> = Transformations.switchMap(filmId) { mFilmId ->
        filmUseCase.getDetailFilm(mFilmId).asLiveData()
    }

    var getTvShow: LiveData<Resource<Film>> = Transformations.switchMap(filmId) { mFilmId ->
        filmUseCase.getDetailTv(mFilmId).asLiveData()
    }

    fun setFavoriteFilm() {
        val filmResource = getFilm.value

        if (filmResource != null) {
            val film =filmResource.data
            if (film != null) {
                val newState = !film.favorited
                filmUseCase.setFavoriteFilm(film, newState)
            }
        }
    }

    fun setFavoriteTv(){
        val filmResource = getTvShow.value
        if (filmResource != null) {
            val film =filmResource.data
            if (film != null) {
                val newState = !film.favorited
                filmUseCase.setFavoriteFilm(film, newState)
            }
        }
    }
}