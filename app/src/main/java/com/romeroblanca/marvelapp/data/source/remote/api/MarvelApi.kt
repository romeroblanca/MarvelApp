package com.romeroblanca.marvelapp.data.source.remote.api

import com.romeroblanca.marvelapp.data.entity.CharactersEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val TS = "5"
const val API_KEY = "f34655445f284a088a35fdb2f3b8beb1"
const val HASH = "4a95697638469b48b3e860ee11533c09"

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String = TS,
        @Query("apikey") apiKey: String = API_KEY,
        @Query("hash") hash: String = HASH
    ): Response<CharactersEntity>
}