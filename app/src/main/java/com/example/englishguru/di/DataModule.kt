package com.example.englishguru.di

import com.example.englishguru.data.repository.SharedPrefsRepository
import com.example.englishguru.data.network.IRemote
import com.example.englishguru.data.network.Remote
import com.example.englishguru.data.repository.IRepository
import org.koin.dsl.module

val dataModule = module {
    single<IRepository> { SharedPrefsRepository(context = get()) }
    single<IRemote> { Remote() }
}