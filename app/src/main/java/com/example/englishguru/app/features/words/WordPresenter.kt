package com.example.englishguru.app.features.words

import android.content.Context
import com.example.englishguru.data.models.Word

const val AGAIN_INCREASE = 0
const val HARD_INCREASE = 1
const val GOOD_INCREASE = 3
const val EASY_INCREASE = 7

class WordPresenter(private val fragment: IWordView, context: Context): IWordPresenter, OutputPortModel {

    private val model: IWordModel = WordModel(context, this)

    override fun onViewCreated() {
        model.assignRandomWord()
        val wordStr = model.getWord()
        model.fetchWordDataRemotely()
        fragment.showWordTitle(wordStr)
    }

    override fun onShowAnswerButtonPressed() {
        fragment.showWordDetails()
    }

    override fun onAgainButtonPressed() {
//        model.increaseDaysForWord(AGAIN_INCREASE)
//        fragment.showNextWord()
    }

    override fun onHardButtonPressed() {
//        model.increaseDaysForWord(HARD_INCREASE)
//        fragment.showNextWord()
    }

    override fun onGoodButtonPressed() {
//        model.increaseDaysForWord(GOOD_INCREASE)
//        fragment.showNextWord()
    }

    override fun onEasyButtonPressed() {
//        model.increaseDaysForWord(EASY_INCREASE)
//        fragment.showNextWord()
    }

    override fun onFetchComplete(word: Word) {
        fragment.fillWordDetails(word)
    }

    override fun onDestroyView() {
        model.onDestroyView()
    }

}