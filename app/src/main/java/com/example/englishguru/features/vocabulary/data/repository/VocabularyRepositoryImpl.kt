package com.example.englishguru.features.vocabulary.data.repository

import com.example.englishguru.features.vocabulary.data.local.VocabularyLocalDataSource
import com.example.englishguru.features.vocabulary.domain.model.Section
import com.example.englishguru.features.vocabulary.domain.repository.VocabularyRepository
import kotlinx.coroutines.flow.Flow

class VocabularyRepositoryImpl(
    private val localDataSource: VocabularyLocalDataSource
) : VocabularyRepository {
    override fun getSections(): Flow<List<Section>> {
        return localDataSource.getSections()
    }
}