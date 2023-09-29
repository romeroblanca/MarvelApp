package com.romeroblanca.marvelapp.domain.repository

import com.romeroblanca.marvelapp.domain.functional.Result
import com.romeroblanca.marvelapp.domain.failure.Failure
import com.romeroblanca.marvelapp.domain.model.CharactersListModel

interface MarvelRepository {
    suspend fun getCharactersList(): Result<Failure, CharactersListModel>
}