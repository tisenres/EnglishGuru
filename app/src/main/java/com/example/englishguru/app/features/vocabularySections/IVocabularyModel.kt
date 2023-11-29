package com.example.englishguru.app.features.vocabularySections

import com.example.englishguru.app.features.vocabularySections.models.Section

interface IVocabularyModel {
    fun getSection(pos: Int): Section
}