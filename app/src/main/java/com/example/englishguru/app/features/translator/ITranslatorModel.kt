package com.example.englishguru.app.features.translator

interface ITranslatorModel {
    fun fetchWordDataRemotely(
        text: String,
        sourceLang: String,
        targetLang: String
    )

    fun getLanguageByPos(selectedSourceLanguage: String): String
}
