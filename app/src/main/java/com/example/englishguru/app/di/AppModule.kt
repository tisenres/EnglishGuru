package com.example.englishguru.app.di

import com.example.englishguru.app.features.main.MainActivity
import com.example.englishguru.app.features.words.IWordModel
import com.example.englishguru.app.features.words.IWordPresenter
import com.example.englishguru.app.features.words.IWordView
import com.example.englishguru.app.features.words.WordFragment
import com.example.englishguru.app.features.words.WordPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { androidContext() as MainActivity }
//    factory<IWordPresenter> { WordPresenter(get(), ) }
}