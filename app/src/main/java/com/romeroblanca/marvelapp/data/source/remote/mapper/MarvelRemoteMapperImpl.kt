package com.romeroblanca.marvelapp.data.source.remote.mapper

import com.romeroblanca.marvelapp.data.entity.CharactersEntity
import com.romeroblanca.marvelapp.data.entity.Character
import com.romeroblanca.marvelapp.domain.model.CharacterModel
import com.romeroblanca.marvelapp.domain.model.CharactersListModel

class MarvelRemoteMapperImpl () : MarvelRemoteMapper {
     override fun toCharactersListModel(entity: CharactersEntity): CharactersListModel {
        return CharactersListModel(
             entity.data?.results?.map {
                 toCharactersModel(it)
             } ?: emptyList()
        )
    }

    private fun toCharactersModel(character: Character) = CharacterModel(
        name = character.name ?: ""
    )
}