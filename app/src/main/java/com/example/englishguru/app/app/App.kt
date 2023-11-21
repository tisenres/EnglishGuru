package com.example.englishguru.app.app

import android.app.Application
import com.example.englishguru.app.di.appModule
import com.example.englishguru.app.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, dataModule))
        }
    }
}