package com.example.englishguru.app.features.vocabularySections

class VocabularyPresenter(private val fragment: IVocabularyView): IVocabularyPresenter {

    private val model: IVocabularyModel = VocabularyModel()

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