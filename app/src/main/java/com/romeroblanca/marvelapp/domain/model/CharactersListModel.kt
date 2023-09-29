package com.romeroblanca.marvelapp.domain.model

data class CharactersListModel(
    val list: List<CharacterModel>
)

data class CharacterModel (
    val name: String
)