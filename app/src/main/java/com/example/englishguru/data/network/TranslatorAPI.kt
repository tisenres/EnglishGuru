package com.example.englishguru.data.network

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TranslatorAPI {

    @FormUrlEncoded
    @POST("v2/translate")
    fun fetchTranlationData(
        @Field("auth_key") apiKey: String,
        @Field("text") text: String,
        @Field("source_lang") sourceLang: String,
        @Field("target_lang") targetLang: String
    ): Observable<TransResponse>
}