package com.dicoding.core.utils

import com.dicoding.core.data.source.local.entity.FilmEntity
import com.dicoding.core.domain.model.Film

object DataMapper {

    fun mapEntitiesToDomain(input: List<FilmEntity>): List<Film> =
        input.map {
            Film(
                id =  it.id,
                title =  it.title,
                genre = it.genre,
                overview = it.overview,
                imdbScore = it.imdbScore,
                releaseYear = it.releaseYear,
                duration = it.duration,
                photo = it.photo,
                favorited = it.favorited,
                type = it.type

            )
        }
    fun convertEntityToDomain(input: FilmEntity): Film = Film(
        id =  input.id,
        title =  input.title,
        genre = input.genre,
        overview = input.overview,
        imdbScore = input.imdbScore,
        releaseYear = input.releaseYear,
        duration = input.duration,
        photo = input.photo,
        favorited = input.favorited,
        type = input.type

    )
    fun mapDomainToEntity(input: Film) = FilmEntity(
        id =  input.id,
        title =  input.title,
        genre = input.genre,
        overview = input.overview,
        imdbScore = input.imdbScore,
        releaseYear = input.releaseYear,
        duration = input.duration,
        photo = input.photo,
        favorited = input.favorited,
        type = input.type
    )
}