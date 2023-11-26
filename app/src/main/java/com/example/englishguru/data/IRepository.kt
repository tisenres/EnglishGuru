package com.example.englishguru.data

import com.example.englishguru.data.models.Word

interface IRepository {
    fun getWordInfo(): Word
    fun updateWord(word: Word)
}