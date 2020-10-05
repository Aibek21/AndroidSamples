package com.example.mvvmapplication

import android.app.Application
import com.example.mvvmapplication.di.*

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
//            androidLogger()
            androidContext(this@MainApplication)
            modules(
                viewModelModule,
                useCaseModule,
                repositoryModule,
                networkModule,
                sharedPrefModule
            )
        }
    }
}