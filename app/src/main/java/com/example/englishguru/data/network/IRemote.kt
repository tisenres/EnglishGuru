package com.example.englishguru.data.network

import io.reactivex.Observable
import io.reactivex.Single

interface IRemote {
    fun fetchWordDataRemotely(query: String): Single<WordResponse>
    fun fetchTranslationData(text: String,
                             sourceLang: String,
                             targetLang: String
    ): Single<TranslationResponse>
}