package com.romeroblanca.marvelapp.data.source.remote

import com.romeroblanca.marvelapp.data.source.remote.api.MarvelApi
import com.romeroblanca.marvelapp.data.source.remote.mapper.MarvelRemoteMapper
import com.romeroblanca.marvelapp.domain.failure.Failure
import com.romeroblanca.marvelapp.domain.failure.Failure.UnknownFailure
import com.romeroblanca.marvelapp.domain.failure.Failure.NetworkConnectionFailure
import com.romeroblanca.marvelapp.domain.functional.Result
import com.romeroblanca.marvelapp.domain.functional.Result.Error
import com.romeroblanca.marvelapp.domain.functional.Result.Success
import com.romeroblanca.marvelapp.domain.model.CharactersListModel

class MarvelRemoteSourceImpl(
    private val marvelApi: MarvelApi,
    private val mapper: MarvelRemoteMapper
) : MarvelRemoteSource {
    override suspend fun getCharactersList(): Result<Failure, CharactersListModel> {
        return try {
            val response = marvelApi.getCharacters()
            if(response.isSuccessful) {
                Success(mapper.toCharactersListModel(response.body()!!))
            } else {
                Error(UnknownFailure)
            }
        } catch (exception: Exception) {
            Error(NetworkConnectionFailure)
        }
    }
}