package dev.nashe.myweather.utils

sealed class Result<out T : Any> {
    /* helper class for managing network connections */

    data class Success<out T : Any>(val data: T) : Result<T>()

    data class Error(val message: String?) : Result<Nothing>()

    object Loading : Result<Nothing>()

    object Idle : Result<Nothing>()
}