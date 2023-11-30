package com.example.englishguru.app.features.translator

interface ITranslatorPresenter {
    fun onTranslateButtonPressed(textToTranslate: String, sourceLang: String, targetLang: String)
}
