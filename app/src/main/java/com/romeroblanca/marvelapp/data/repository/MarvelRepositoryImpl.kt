package com.romeroblanca.marvelapp.data.repository

import com.romeroblanca.marvelapp.data.source.remote.MarvelRemoteSource
import com.romeroblanca.marvelapp.domain.repository.MarvelRepository
import com.romeroblanca.marvelapp.domain.failure.Failure
import com.romeroblanca.marvelapp.domain.functional.Result
import com.romeroblanca.marvelapp.domain.model.CharactersListModel

class MarvelRepositoryImpl (
    private val marvelRemoteSource: MarvelRemoteSource
) : MarvelRepository {
    override suspend fun getCharactersList() :
            Result<Failure, CharactersListModel> =
        marvelRemoteSource.getCharactersList()
}