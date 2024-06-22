package com.example.englishguru.features.vocabularySections

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class VocabularyPresenter(private val fragment: IVocabularyView): IVocabularyPresenter, KoinComponent {

    private val model: IVocabularyModel by inject { parametersOf(this) }

    override fun onButtonPressed(pos: Int) {
        fragment.navigateToWordFragment(
            model.getSection(pos).startWordPos,
            model.getSection(pos).endWordPos
        )
    }

    override fun getSectionName(position: Int): String {
        return model.getSection(position).name
    }

    override fun getSectionDescription(position: Int): String {
        return model.getSection(position).description
    }

    override fun getNumberOfWords(position: Int): Int {
        return model.getSection(position).numberOfWords
    }
}