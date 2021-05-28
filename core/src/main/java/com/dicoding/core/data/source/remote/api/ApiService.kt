package com.dicoding.core.data.source.remote.api

import com.dicoding.myfavoriteapp.core.BuildConfig
import com.dicoding.core.data.source.remote.response.FilmDetailResponse
import com.dicoding.core.data.source.remote.response.FilmListResponse
import com.dicoding.core.data.source.remote.response.TvDetailResponse
import com.dicoding.core.data.source.remote.response.TvListResponse
import retrofit2.http.*

interface ApiService {
    @GET("movie/popular?api_key=${BuildConfig.MOVIE_TOKEN}&language=en-US")
    suspend fun getFilmList(): FilmListResponse

    @GET("movie/{id}?api_key=${BuildConfig.MOVIE_TOKEN}&language=en-US")
    suspend fun getFilm( @Path("id") id: Int): FilmDetailResponse

    @GET("tv/popular?api_key=${BuildConfig.MOVIE_TOKEN}&language=en-US")
    suspend fun getTvShowList(): TvListResponse

    @GET("tv/{id}?api_key=${BuildConfig.MOVIE_TOKEN}&language=en-US")
    suspend fun getTvShow( @Path("id") id: Int): TvDetailResponse

}