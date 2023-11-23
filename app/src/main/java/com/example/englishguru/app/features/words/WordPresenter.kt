package com.example.englishguru.app.features.words

class WordPresenter(private val fragment: IWordView): IWordPresenter {

    private val model: IWordModel = WordModel()

    override fun getWord(): String {
        return model.getWord()
    }
}