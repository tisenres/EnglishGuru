package com.example.englishguru.features.translator

interface ITranslatorModel {
    fun fetchWordDataRemotely(
        text: String,
        sourceLang: String,
        targetLang: String
    )
}
