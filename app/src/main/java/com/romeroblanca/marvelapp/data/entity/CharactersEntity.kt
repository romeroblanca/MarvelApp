package com.romeroblanca.marvelapp.data.entity

import com.squareup.moshi.Json

data class CharactersEntity (
    @Json(name = "data") val data: Data?
)

data class Data(
    @Json(name = "results") val results: List<Character>?
)

data class Character(
    @Json(name = "name") val name: String?
)