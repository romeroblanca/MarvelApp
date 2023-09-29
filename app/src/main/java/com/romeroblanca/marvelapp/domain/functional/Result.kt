package com.romeroblanca.marvelapp.domain.functional

sealed class Result<out E, out S>  {

    data class Error<out E> internal constructor(val value: E) : Result<E, Nothing>() {
        companion object {
          operator fun <E> invoke(e: E): Result<E, Nothing> = Error(e)
        }
      }

    data class Success<out S> internal constructor(val value: S) : Result<Nothing, S>() {
        companion object {
          operator fun <S> invoke(s: S): Result<Nothing, S> = Success(s)
        }
    }

    companion object {
        fun <S> success(value: S): Result<Nothing, S> = Success(value)
        fun <E> error(value: E): Result<E, Nothing> = Error(value)
    }
}