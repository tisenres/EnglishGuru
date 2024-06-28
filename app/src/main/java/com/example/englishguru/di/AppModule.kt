package com.example.englishguru.di

import com.example.englishguru.features.vocabulary.data.local.VocabularyLocalDataSource
import com.example.englishguru.features.vocabulary.data.repository.VocabularyRepositoryImpl
import com.example.englishguru.features.vocabulary.domain.repository.VocabularyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideVocabularyLocalDataSource(): VocabularyLocalDataSource {
        return VocabularyLocalDataSource()
    }

    @Provides
    @Singleton
    fun provideVocabularyRepository(
        localDataSource: VocabularyLocalDataSource
    ): VocabularyRepository {
        return VocabularyRepositoryImpl(localDataSource)
    }
}