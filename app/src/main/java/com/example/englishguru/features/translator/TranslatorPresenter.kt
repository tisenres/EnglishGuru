package com.example.englishguru.features.translator

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class TranslatorPresenter(private val fragment: ITranslatorView) : ITranslatorPresenter, TransModelOutputPort,
    KoinComponent {

    private val model: ITranslatorModel by inject { parametersOf(this) }

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
