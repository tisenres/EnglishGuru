package com.example.englishguru.app.di

import com.example.englishguru.app.features.main.MainActivity
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { androidContext() as MainActivity }
}