package com.example.englishguru.data.network

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_WORD_URL = "https://wordsapiv1.p.rapidapi.com/"
private const val BASE_TRANS_URL = "https://google-translate1.p.rapidapi.com/"

class Remote: IRemote {

    private val wordsAPI: WordsAPI
    private val translateAPI: TranslatorAPI

    init {
        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY }

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val wordRetrofit = Retrofit.Builder()
            .baseUrl(BASE_WORD_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        wordsAPI = wordRetrofit.create(WordsAPI::class.java)

        val transRetrofit = Retrofit.Builder()
            .baseUrl(BASE_TRANS_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        translateAPI = transRetrofit.create(TranslatorAPI::class.java)
    }

    override fun fetchWordDataRemotely(query: String): Single<WordResponse> {
        return wordsAPI.loadWordInfo(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun fetchTranslationData(
        apiKey: String,
        text: String,
        sourceLang: String,
        targetLang: String
    ): Single<TransResponse> {
        return translateAPI.fetchTranslationData(apiKey, text, sourceLang, targetLang)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}