package com.example.englishguru.app.features.words

import android.content.Context

const val AGAIN_INCREASE = 0
const val HARD_INCREASE = 1
const val GOOD_INCREASE = 3
const val EASY_INCREASE = 7

class WordPresenter(private val fragment: IWordView, context: Context): IWordPresenter {

    private val model: IWordModel = WordModel(context)

    override fun getWord(): String {
        return model.getWord()
    }

    override fun onAgainButtonPressed() {
        model.increaseDaysForWord(AGAIN_INCREASE)
        fragment.showNextWord()
    }

    override fun onHardButtonPressed() {
        model.increaseDaysForWord(HARD_INCREASE)
        fragment.showNextWord()
    }

    override fun onGoodButtonPressed() {
        model.increaseDaysForWord(GOOD_INCREASE)
        fragment.showNextWord()
    }

    override fun onEasyButtonPressed() {
        model.increaseDaysForWord(EASY_INCREASE)
        fragment.showNextWord()
    }

    override fun getDefinition(): String {
        return model.getWordInfo().definition
    }

    override fun getPartOfSpeech(): String {
        return model.getWordInfo().partOfSpeech
    }

    override fun getSynonyms(): List<String> {
        return model.getWordInfo().synonyms
    }

    override fun getDerivation(): List<String> {
        return model.getWordInfo().derivation
    }

    override fun getExamples(): List<String> {
        return model.getWordInfo().examples
    }

    override fun getSimilarTo(): List<String> {
        return model.getWordInfo().similarTo
    }

}