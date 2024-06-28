package com.example.englishguru.features.vocabulary.data.local

import com.example.englishguru.features.vocabulary.domain.model.Section
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VocabularyLocalDataSource {
    fun getSections(): Flow<List<Section>> = flow {
        val sections = listOf(
            Section.A1(),
            Section.A2(),
            Section.B1(),
            Section.B2(),
            Section.C1()
        )
        emit(sections)
    }
}