package com.dicoding.core.data.source.remote.api

sealed class ApiResponse<out R> {
    data class success<out T>(val data: T) : ApiResponse<T>()
    data class error(val errorMessage: String) : ApiResponse<Nothing>()
    data class empty(val message: String) : ApiResponse<Nothing>()

}