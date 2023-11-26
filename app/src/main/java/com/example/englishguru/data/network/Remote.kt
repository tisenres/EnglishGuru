package com.example.englishguru.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://wordsapiv1.p.rapidapi.com/"

object Remote: IRemote {

    val instance: WordsAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(WordsAPI::class.java)
    }
}