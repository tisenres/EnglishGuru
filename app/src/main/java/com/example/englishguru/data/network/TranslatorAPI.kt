package com.example.englishguru.data.network

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface TranslatorAPI {

    @POST("language/translate/v2")
    @FormUrlEncoded
    fun fetchTranslationData(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Field("q") text: String,
        @Field("source") sourceLang: String,
        @Field("target") targetLang: String
    ): Single<TransResponse>
}