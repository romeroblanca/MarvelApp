package com.romeroblanca.marvelapp.data.source.remote.mapper

import com.romeroblanca.marvelapp.data.entity.CharactersEntity
import com.romeroblanca.marvelapp.domain.model.CharactersListModel

interface MarvelRemoteMapper {
    fun toCharactersListModel(entity: CharactersEntity): CharactersListModel
}