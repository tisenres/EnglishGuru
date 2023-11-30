package com.example.englishguru.app.features.translator

interface ITranslatorPresenter {
    fun translateText(apiKey: String, query: String, source: String, target: String)

}
