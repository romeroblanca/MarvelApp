package com.romeroblanca.marvelapp.di

import com.romeroblanca.marvelapp.data.repository.MarvelRepositoryImpl
import com.romeroblanca.marvelapp.data.source.remote.MarvelRemoteSource
import com.romeroblanca.marvelapp.data.source.remote.MarvelRemoteSourceImpl
import com.romeroblanca.marvelapp.data.source.remote.api.MarvelApi
import com.romeroblanca.marvelapp.data.source.remote.mapper.MarvelRemoteMapper
import com.romeroblanca.marvelapp.data.source.remote.mapper.MarvelRemoteMapperImpl
import com.romeroblanca.marvelapp.domain.repository.MarvelRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<MarvelRepository> {
        MarvelRepositoryImpl(get())
    }

    single<MarvelRemoteSource> {
        MarvelRemoteSourceImpl(get(), get())
    }

    single<MarvelRemoteMapper> {
        MarvelRemoteMapperImpl()
    }

    single<MarvelApi> {
        getMarvelApi(get())
    }

}

private fun getMarvelApi(retrofit: Retrofit) =
    retrofit.create(MarvelApi::class.java)