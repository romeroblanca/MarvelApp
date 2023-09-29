package com.romeroblanca.marvelapp.di

import com.romeroblanca.marvelapp.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

    viewModelOf(::ListViewModel)

}