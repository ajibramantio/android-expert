package com.dicoding.core.data.source.remote

import com.dicoding.core.data.source.local.entity.FilmEntity
import com.dicoding.core.data.source.remote.api.ApiResponse
import com.dicoding.core.data.source.remote.api.ApiService
import com.dicoding.core.data.source.remote.response.GenreResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val remoteDataSource: ApiService) {

    suspend fun getAllFilm(): Flow<ApiResponse<List<FilmEntity>>> {
        return flow<ApiResponse<List<FilmEntity>>>{
            try {
                val response = remoteDataSource.getFilmList()
                val data = response.allFilm
                val filmList = ArrayList<FilmEntity>()
                if(data.size>0){
                    for (i in data) {
                        val film =
                            FilmEntity(
                                i.id,
                                i.title ?: "",
                                ArrayList<GenreResponse>(),
                                i.overview,
                                i.imdbScore,
                                i.releaseYear ?: "",
                                i.duration ?: 0,
                                "https://image.tmdb.org/t/p/w500/"+i.photo,
                                false,
                                "film"
                            )
                        filmList.add(film)
                    }
                    emit(ApiResponse.success(filmList))
                }
                else{
                    emit(ApiResponse.empty("empty"))
                }
            }
            catch (e: Exception){
                emit(ApiResponse.error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllTvShow(): Flow<ApiResponse<List<FilmEntity>>> {
        return flow<ApiResponse<List<FilmEntity>>>{
            try {
                val response = remoteDataSource.getTvShowList()
                val data = response.allFilm
                val filmList = ArrayList<FilmEntity>()
                if(data.size>0){
                    for (i in data) {
                        val film =
                            FilmEntity(
                                i.id,
                                i.title ?: "",
                                ArrayList<GenreResponse>(),
                                i.overview,
                                i.imdbScore,
                                i.releaseYear ?: "",
                                i.duration ?: 0,
                                "https://image.tmdb.org/t/p/w500/"+i.photo,
                                false,
                                "tvshow"
                            )
                        filmList.add(film)
                    }
                    emit(ApiResponse.success(filmList))
                }
                else{
                    emit(ApiResponse.empty("empty"))
                }
            }
            catch (e: Exception){
                emit(ApiResponse.error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

   fun getDetailFilm(id: Int): Flow<ApiResponse<FilmEntity>> {
       return flow {
           try{
               val filmResponse = remoteDataSource.getFilm(id)
               val film: FilmEntity
               film =
                   FilmEntity(
                       filmResponse.id,
                       filmResponse.title ?: "",
                       filmResponse.genre,
                       filmResponse.overview,
                       filmResponse.imdbScore,
                       filmResponse.releaseYear ?: "",
                       filmResponse.duration ?: 0,
                       "https://image.tmdb.org/t/p/w500/"+filmResponse.photo,
                       false,
                       "film"
                   )
               emit(ApiResponse.success(film))
           }
           catch(e: Exception){
               emit(ApiResponse.error(e.toString()))
           }
       }.flowOn(Dispatchers.IO)
    }

    fun getDetailTv(id: Int): Flow<ApiResponse<FilmEntity>> {
        return flow {
            try{
                val filmResponse = remoteDataSource.getTvShow(id)
                val film: FilmEntity
                film =
                    FilmEntity(
                        filmResponse.id,
                        filmResponse.title ?: "",
                        filmResponse.genre,
                        filmResponse.overview,
                        filmResponse.imdbScore,
                        filmResponse.releaseYear ?: "",
                        filmResponse.duration ?: 0,
                        "https://image.tmdb.org/t/p/w500/"+filmResponse.photo,
                        false,
                        "tvshow"
                    )
                emit(ApiResponse.success(film))
            }
            catch(e: Exception){
                emit(ApiResponse.error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}