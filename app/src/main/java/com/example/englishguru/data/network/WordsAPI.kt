package com.example.englishguru.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface WordsAPI {

    @GET("words/{word}")
    @Headers("X-RapidAPI-Host: wordsapiv1.p.rapidapi.com")

    fun loadWordInfo(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Path("word") word: String
    ): Single<WordResponse>
}