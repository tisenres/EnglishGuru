package com.example.englishguru.data.network

import android.view.translation.TranslationResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface WordsAPI {

    @GET("words/{word}")
    @Headers(
        "X-RapidAPI-Key: 8f6dc7db8amsh49a9ed984e64e9dp1f16d5jsn18b2f9e1fe68",
        "X-RapidAPI-Host: wordsapiv1.p.rapidapi.com"
    )
    fun loadWordInfo(@Path("word") word: String): Single<WordResponse>
}