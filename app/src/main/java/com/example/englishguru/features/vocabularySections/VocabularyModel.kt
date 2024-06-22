package com.example.englishguru.features.vocabularySections

import com.example.englishguru.app.features.vocabularySections.models.Section

class VocabularyModel: IVocabularyModel {

    override fun getSection(pos: Int): Section {
        return when (pos) {
            0 -> Section.A1()
            1 -> Section.A2()
            2 -> Section.B1()
            3 -> Section.B2()
            else -> Section.C1()
        }
    }
}