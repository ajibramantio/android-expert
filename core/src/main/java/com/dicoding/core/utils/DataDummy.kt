package com.dicoding.core.utils

import com.dicoding.core.data.source.local.entity.FilmEntity
import com.dicoding.core.data.source.remote.response.FilmDetailResponse
import com.dicoding.core.data.source.remote.response.GenreResponse
import com.dicoding.core.data.source.remote.response.TvDetailResponse

object DataDummy {
    fun generateDummyFilm(): List<FilmEntity> {

        val film = ArrayList<FilmEntity>()
        val arrGenre = ArrayList<GenreResponse>()
        val genre = GenreResponse(1,"action")
        arrGenre.add(genre)
        film.add(
            FilmEntity(
                1,
                "Captain America: The First Avenger",
                arrGenre,
                "Steve Rogers, a rejected military soldier, transforms into Captain America after taking a dose of a \"Super-Soldier serum\". But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization.",
                6.9,
                "2011",
                124,
                "https://dummyimage.com/600x400/000/fff",
                false,
                "film"
            )
        )

        return film
    }

    fun generateDummyTvShows(): List<FilmEntity> {

        val tvShows = ArrayList<FilmEntity>()
        val arrGenre = ArrayList<GenreResponse>()
        val genre = GenreResponse(1,"animation")
        arrGenre.add(genre)

        tvShows.add(
            FilmEntity(
                1,
                "The Simpsons",
                arrGenre,
                "The satiric adventures of a working-class family in the misfit city of Springfield.",
                8.6,
                "1989",
                22,
                "https://dummyimage.com/600x400/000/fff",
                false,
                "tvshow"
            )
        )


        return tvShows
    }

    fun generateDummyFavoriteFilm(): List<FilmEntity> {

        val film = ArrayList<FilmEntity>()
        val arrGenre = ArrayList<GenreResponse>()
        val genre = GenreResponse(1,"romance")
        arrGenre.add(genre)
        film.add(
            FilmEntity(
                1,
                "Captain America: The First Avenger",
                arrGenre,
                "Steve Rogers, a rejected military soldier, transforms into Captain America after taking a dose of a \"Super-Soldier serum\". But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization.",
                6.9,
                "2011",
                124,
                "https://dummyimage.com/600x400/000/fff",
                false,
                "film"
            )
        )

        return film
    }

    fun generateDummyFavoriteTvShows(): List<FilmEntity> {

        val tvShows = ArrayList<FilmEntity>()
        val arrGenre = ArrayList<GenreResponse>()
        val genre = GenreResponse(1,"romance")
        arrGenre.add(genre)

        tvShows.add(
            FilmEntity(
                1,
                "The Simpsons",
                arrGenre,
                "The satiric adventures of a working-class family in the misfit city of Springfield.",
                8.6,
                "1989",
                22,
                "https://dummyimage.com/600x400/000/fff",
                false,
                "tvshow"
            )
        )

        return tvShows
    }

    fun generateDummyRemoteTvShows(): ArrayList<TvDetailResponse> {

        val tvShows = ArrayList<TvDetailResponse>()
        val arrGenre = ArrayList<GenreResponse>()
        val genre = GenreResponse(1,"animation")
        arrGenre.add(genre)

        tvShows.add(
            TvDetailResponse(
                1,
                "The Simpsons",
                arrGenre,
                "The satiric adventures of a working-class family in the misfit city of Springfield.",
                8.6,
                "1989",
                22,
                "https://dummyimage.com/600x400/000/fff"
            )
        )

        return tvShows
    }

    fun generateDummyRemoteFilm(): ArrayList<FilmDetailResponse> {

        val film = ArrayList<FilmDetailResponse>()
        val arrGenre = ArrayList<GenreResponse>()
        val genre = GenreResponse(1,"action")
        arrGenre.add(genre)
        film.add(
            FilmDetailResponse(
                1,
                "Captain America: The First Avenger",
                arrGenre,
                "Steve Rogers, a rejected military soldier, transforms into Captain America after taking a dose of a \"Super-Soldier serum\". But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization.",
                6.9,
                "2011",
                124,
                "https://dummyimage.com/600x400/000/fff"
            )
        )

        return film
    }

}