package com.example.englishguru.app.features.translator

class TranslatorPresenter(private val fragment: ITranslatorView) : ITranslatorPresenter, TransModelOutputPort {

    private val model: ITranslatorModel = TranslatorModel(this)

    override fun onFetchComplete(response: String) {
        fragment.initTargetTextField(response)
    }

    override fun onTranslateButtonPressed(
        textToTranslate: String,
        sourceLang: String,
        targetLang: String
    ) {
        model.fetchWordDataRemotely(textToTranslate, sourceLang, targetLang)
    }
}
