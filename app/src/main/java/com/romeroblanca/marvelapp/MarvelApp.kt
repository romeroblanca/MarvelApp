package com.romeroblanca.marvelapp

import android.app.Application
import com.romeroblanca.marvelapp.di.dataModule
import com.romeroblanca.marvelapp.di.domainModule
import com.romeroblanca.marvelapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class MarvelApp : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger()

            androidContext(this@MarvelApp)

            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}