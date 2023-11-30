package com.example.englishguru.app.features.translator

class TranslatorPresenter(private val fragment: ITranslatorView) : ITranslatorPresenter, TransModelOutputPort {

    private val model: ITranslatorModel = TranslatorModel(this)

    override fun onFetchComplete() {
        TODO("Not yet implemented")
    }
}
