package com.example.englishguru.features.vocabulary.domain.usecases

import com.example.englishguru.features.vocabulary.domain.model.Section
import com.example.englishguru.features.vocabulary.domain.repository.VocabularyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSectionsUseCase @Inject constructor(
    private val repository: VocabularyRepository
) {
    operator fun invoke(): Flow<List<Section>> {
        return repository.getSections()
    }
}