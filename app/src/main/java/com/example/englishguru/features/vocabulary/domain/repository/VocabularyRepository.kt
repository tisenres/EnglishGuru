package com.example.englishguru.features.vocabulary.domain.repository

import com.example.englishguru.features.vocabulary.domain.model.Section
import kotlinx.coroutines.flow.Flow

interface VocabularyRepository {
    fun getSections(): Flow<List<Section>>
}