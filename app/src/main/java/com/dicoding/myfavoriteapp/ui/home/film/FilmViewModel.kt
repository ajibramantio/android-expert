package com.dicoding.myfavoriteapp.ui.home.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.model.Film
import com.dicoding.core.domain.usecase.FilmUseCase
import com.dicoding.core.vo.Resource

class FilmViewModel(private val filmUseCase: FilmUseCase): ViewModel() {

    fun getFilm(): LiveData<Resource<List<Film>>> = filmUseCase.getAllFilm().asLiveData()
}