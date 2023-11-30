package com.example.englishguru.app.features.translator

class TranslatorPresenter(private val fragment: ITranslatorView) : ITranslatorPresenter, TransModelOutputPort {

    private val model: ITranslatorModel = TranslatorModel(this)

    override fun onFetchComplete() {
    }

    override fun translateText(s: String, s1: String, s2: String, deeplApiKey: String) {
        model.fetchWordDataRemotely(s, s1, s2, deeplApiKey)
    }
}
