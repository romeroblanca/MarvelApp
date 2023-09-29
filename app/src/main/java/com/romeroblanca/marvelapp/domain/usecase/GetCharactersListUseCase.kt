package com.romeroblanca.marvelapp.domain.usecase

import com.romeroblanca.marvelapp.domain.failure.Failure
import com.romeroblanca.marvelapp.domain.functional.Result
import com.romeroblanca.marvelapp.domain.model.CharactersListModel

interface GetCharactersListUseCase {
    suspend fun invoke(): Result<Failure, CharactersListModel>
}