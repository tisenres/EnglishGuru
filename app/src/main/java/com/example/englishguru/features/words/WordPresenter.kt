package com.example.englishguru.features.words

import com.example.englishguru.data.models.Word
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class WordPresenter(private val fragment: IWordView, startWordPos: Int, endWorPos: Int): IWordPresenter, WordModelOutputPort, KoinComponent {

    private val model: IWordModel by inject { parametersOf(this, startWordPos, endWorPos) }

    override fun onViewCreated() {
        model.assignRandomWord()
        val wordStr = model.getWord()
        model.fetchWordDataRemotely()
        fragment.showWordTitle(wordStr)
    }

    override fun onShowAnswerButtonPressed() {
        fragment.showWordDetails()
    }

    override fun onFetchComplete(word: Word) {
        fragment.fillWordDetails(word)
        fragment.setUpVisibilityForEmptyCards()
    }

    override fun onDestroyView() {
        model.onDestroyView()
    }

}