package com.example.englishguru.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface WordsAPI {
    @GET("/api/v1/word/{word}/a1")
    fun getA1Words(@Path("word") word: String): Single<List<String>>
}
