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
    @Headers("X-RapidAPI-Key: 8f6dc7db8amsh49a9ed984e64e9dp1f16d5jsn18b2f9e1fe68")
    fun fetchTranslationData(
        @Field("q") text: String,
        @Field("source") sourceLang: String,
        @Field("target") targetLang: String
    ): Single<TransResponse>
}