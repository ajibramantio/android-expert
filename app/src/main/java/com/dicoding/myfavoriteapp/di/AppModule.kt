package com.dicoding.myfavoriteapp.di

import com.dicoding.core.domain.usecase.FilmInteractor
import com.dicoding.core.domain.usecase.FilmUseCase
import com.dicoding.myfavoriteapp.ui.detail.DetailFilmViewModel
import com.dicoding.myfavoriteapp.ui.home.film.FilmViewModel
import com.dicoding.myfavoriteapp.ui.home.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<FilmUseCase> { FilmInteractor(get()) }
}

val viewModelModule = module {
    viewModel { DetailFilmViewModel(get()) }
    viewModel { FilmViewModel(get()) }
    viewModel { TvShowViewModel(get()) }

}