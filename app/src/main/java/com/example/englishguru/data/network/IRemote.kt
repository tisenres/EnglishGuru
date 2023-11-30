package com.example.englishguru.data.network

import io.reactivex.Observable
import io.reactivex.Single

interface IRemote {
    fun fetchWordDataRemotely(query: String): Single<WordResponse>
    fun fetchTranlationData(apiKey: String,
                            text: String,
                            sourceLang: String,
                            targetLang: String
    ): Observable<TransResponse>
}