package com.romeroblanca.marvelapp.di

import com.romeroblanca.marvelapp.domain.usecase.GetCharactersListUseCase
import com.romeroblanca.marvelapp.domain.usecase.GetCharactersListUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    single<GetCharactersListUseCase> { GetCharactersListUseCaseImpl(get()) }

}
