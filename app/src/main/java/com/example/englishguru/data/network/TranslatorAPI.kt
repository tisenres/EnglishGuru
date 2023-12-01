package com.example.englishguru.data.network

import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface TranslatorAPI {

    @Headers(
        "content-type: application/json",
        "X-RapidAPI-Host: lecto-translation.p.rapidapi.com"
    )
    @POST("/v1/translate/text")
    fun fetchTranslationData(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Body request: RequestBody
    ): Single<TranslationResponse>
}