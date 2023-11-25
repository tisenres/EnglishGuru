package com.example.englishguru.app.features.words

const val AGAIN_INCREASE = 0
const val HARD_INCREASE = 1
const val GOOD_INCREASE = 3
const val EASY_INCREASE = 7

class WordPresenter(private val fragment: IWordView): IWordPresenter {

    private val model: IWordModel = WordModel()

    override fun getWord(): String {
        return model.getWord()
    }

    override fun onAgainButtonPressed() {
        model.increaseDaysForWord(AGAIN_INCREASE)
    }

    override fun onHardButtonPressed() {
        model.increaseDaysForWord(HARD_INCREASE)
    }

    override fun onGoodButtonPressed() {
        model.increaseDaysForWord(GOOD_INCREASE)
    }

    override fun onEasyButtonPressed() {
        model.increaseDaysForWord(EASY_INCREASE)
    }
}