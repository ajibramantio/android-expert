package com.dicoding.myfavoriteapp.ui.home.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.model.Film
import com.dicoding.core.domain.usecase.FilmUseCase
import com.dicoding.core.vo.Resource

class TvShowViewModel(private val filmUseCase: FilmUseCase): ViewModel() {

    fun getTvShow(): LiveData<Resource<List<Film>>> = filmUseCase.getAllTvShow().asLiveData()
}