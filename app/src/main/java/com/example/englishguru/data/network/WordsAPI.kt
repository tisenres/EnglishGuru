package com.example.englishguru.data.network

import com.example.englishguru.data.models.WordResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface WordsAPI {

    @GET("words/{word}")
    @Headers(
        "X-RapidAPI-Key: 8f6dc7db8amsh49a9ed984e64e9dp1f16d5jsn18b2f9e1fe68",
        "X-RapidAPI-Host: wordsapiv1.p.rapidapi.com"
    )
    fun loadWordInfo(@Path("word") word: String): Single<WordResponse>
}