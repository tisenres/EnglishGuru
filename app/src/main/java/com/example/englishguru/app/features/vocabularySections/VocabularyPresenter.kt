package com.example.englishguru.app.features.vocabularySections

import com.example.englishguru.app.features.words.WordFragment

class VocabularyPresenter(private val fragment: IVocabularyView): IVocabularyPresenter {
    override fun onButtonPressed() {
        WordFragment.newInstance("sjdshdhsd", "skdjskjdkjsd")
    }
}