package com.example.englishguru.app.features.translator

interface ITranslatorPresenter {
    fun translateText(s: String, s1: String, s2: String, deeplApiKey: String)

}
