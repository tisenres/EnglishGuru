package com.example.englishguru.data

import com.example.englishguru.data.models.Word

interface IRepository {
    val wordsAreLoaded: Boolean
    fun getWordInfo(): Word
    fun updateWord(word: Word)
    fun addWords(wordList: List<String>)
}