package com.example.englishguru.app.features.words

import com.example.englishguru.data.models.Word

class WordPresenter(private val fragment: IWordView, startWordPos: Int, endWorPos: Int): IWordPresenter, OutputPortModel {

    private val model: IWordModel = WordModel(this, startWordPos, endWorPos)

    override fun onViewCreated() {
        model.assignRandomWord()
        val wordStr = model.getWord()
        model.fetchWordDataRemotely()
        fragment.showWordTitle(wordStr)
    }

    override fun onShowAnswerButtonPressed() {
        fragment.showWordDetails()
    }

//    override fun onAgainButtonPressed() {
//        model.saveWordToShowLately()
//        model.increaseDaysForWord(AGAIN_INCREASE)
//        fragment.showNextWord()
//        onViewCreated()
//    }

//    override fun onHardButtonPressed() {
//        model.increaseDaysForWord(HARD_INCREASE)
//        fragment.showNextWord()
//        onViewCreated()
//    }

//    override fun onGoodButtonPressed() {
//        model.increaseDaysForWord(GOOD_INCREASE)
//        fragment.showNextWord()
//        onViewCreated()
//    }

//    override fun onEasyButtonPressed() {
//        model.increaseDaysForWord(EASY_INCREASE)
//        fragment.showNextWord()
//        onViewCreated()
//    }

    override fun onFetchComplete(word: Word) {
        fragment.fillWordDetails(word)
        fragment.setUpVisibilityForEmptyCards()
    }

    override fun onDestroyView() {
        model.onDestroyView()
    }

}