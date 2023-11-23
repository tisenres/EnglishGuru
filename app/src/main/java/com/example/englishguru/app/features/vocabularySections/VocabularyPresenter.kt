package com.example.englishguru.app.features.vocabularySections

class VocabularyPresenter(private val fragment: IVocabularyView): IVocabularyPresenter {

    private val model: IVocabularyModel = VocabularyModel()

    override fun onButtonPressed(pos: Int) {
        fragment.navigateToWordFragment()
    }

    override fun getSectionName(position: Int): String {
        return model.getSections()[position].name
    }

    override fun getSectionDescription(position: Int): String {
        return model.getSections()[position].description
    }

    override fun getNumberOfWords(position: Int): Int {
        return model.getSections()[position].numberOfWords
    }
}