package com.droid.domain

sealed class Result<out T : Any> {

    class Success<out T : Any>(val data: T?) : Result<T>()

    class Failure(val exception: String) : Result<Nothing>()

    object Loading : Result<Nothing>()
}