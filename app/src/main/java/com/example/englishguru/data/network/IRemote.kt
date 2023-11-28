package com.example.englishguru.data.network

import io.reactivex.Single

interface IRemote {
    fun fetchWordDataRemotely(query: String): Single<WordResponse>
}