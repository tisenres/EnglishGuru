package com.example.englishguru.app.features.translator

class TranslatorPresenter(private val fragment: ITranslatorView) : ITranslatorPresenter, TransModelOutputPort {

    private val model: ITranslatorModel = TranslatorModel(this)

    override fun onFetchComplete() {
    }

    override fun translateText(apiKey: String, query: String, source: String, target: String) {
        model.fetchWordDataRemotely(apiKey, query, source, target)
    }
}
