package com.romeroblanca.marvelapp.data.source.remote

import com.romeroblanca.marvelapp.domain.failure.Failure
import com.romeroblanca.marvelapp.domain.functional.Result
import com.romeroblanca.marvelapp.domain.model.CharactersListModel

interface MarvelRemoteSource {
    suspend fun getCharactersList(): Result<Failure, CharactersListModel>
}