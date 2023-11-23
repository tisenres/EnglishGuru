package com.example.englishguru.app.features.words

class WordPresenter(private val fragment: IWordView): IWordPresenter {

    private val model: IWordModel = WordModel()
    private var currentWord: String? = null

    override fun getWord(): String {
        val word = model.getWord()
        currentWord = word
        return word
    }

    override fun onAgainButtonPressed() {
        TODO("Not yet implemented")
    }

    override fun onHardButtonPressed() {
        TODO("Not yet implemented")
    }

    override fun onGoodButtonPressed() {
        TODO("Not yet implemented")
    }

    override fun onEasyButtonPressed() {
        TODO("Not yet implemented")
    }
}