package com.example.englishguru.app.features.vocabularySections

class VocabularyPresenter(private val fragment: IVocabularyView): IVocabularyPresenter {

    override fun onButtonPressed(pos: Int) {
        fragment.navigateToWordFragment()
    }
}