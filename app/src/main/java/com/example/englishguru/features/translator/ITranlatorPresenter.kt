package com.example.englishguru.features.translator

interface ITranslatorPresenter {
    fun onTranslateButtonPressed(textToTranslate: String, sourceLang: String, targetLang: String)
}
