package com.example.englishguru.app.features.vocabularySections

import com.example.englishguru.app.features.vocabularySections.models.Section

class VocabularyModel: IVocabularyModel {

    private val sections = mutableListOf<Section>()

    init {
        sections.add(Section("Beginner", "Most frequent words in English for A1 level", 128))
        sections.add(Section("Elementary", "Most frequent words in English for A2 level", 128))
        sections.add(Section("Intermediate", "Most frequent words in English for B1 level", 128))
        sections.add(Section("Upper-Intermediate", "Most frequent words in English for B2 level", 128))
        sections.add(Section("Advanced", "Advanced vocabulary for real English Guru's!", 128))
    }

    override fun getSections(): MutableList<Section> {
        return sections
    }
}