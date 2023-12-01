package com.example.englishguru.data.network

import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TranslatorAPI {

    @Headers(
        "content-type: application/json",
        "X-RapidAPI-Key: 8f6dc7db8amsh49a9ed984e64e9dp1f16d5jsn18b2f9e1fe68",
        "X-RapidAPI-Host: lecto-translation.p.rapidapi.com"
    )
    @POST("/v1/translate/text")
    fun fetchTranslationData(
        @Body request: RequestBody
    ): Single<TranslationResponse>
}