package com.dicoding.favorite.di

import com.dicoding.favorite.favorite.film.FilmFavoriteViewModel
import com.dicoding.favorite.favorite.tvshow.TvShowFavoriteViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val favoritesModule = module {
    viewModel { FilmFavoriteViewModel(get()) }
    viewModel { TvShowFavoriteViewModel(get()) }
}