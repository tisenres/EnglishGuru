package com.example.englishguru.app.di

import com.example.englishguru.data.SharedPrefsRepository
import com.example.englishguru.data.network.IRemote
import com.example.englishguru.data.network.Remote
import org.koin.dsl.module

val dataModule = module {
    single { SharedPrefsRepository(context = get()) }
    single<IRemote> { Remote() }
}