package com.romeroblanca.marvelapp.domain.usecase

import com.romeroblanca.marvelapp.domain.failure.Failure
import com.romeroblanca.marvelapp.domain.repository.MarvelRepository
import com.romeroblanca.marvelapp.domain.functional.Result
import com.romeroblanca.marvelapp.domain.model.CharactersListModel

class GetCharactersListUseCaseImpl(private val repository: MarvelRepository) :
    GetCharactersListUseCase {
    override suspend fun invoke(): Result<Failure, CharactersListModel> =
        repository.getCharactersList()
}