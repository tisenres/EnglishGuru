package com.example.englishguru.app.features.translator

interface ITranslatorModel {
    fun fetchWordDataRemotely(
        apiKey: String,
        text: String,
        sourceLang: String,
        targetLang: String
    )
}
