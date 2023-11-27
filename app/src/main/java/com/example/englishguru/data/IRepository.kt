package com.example.englishguru.data

import com.example.englishguru.data.models.Word

interface IRepository {
    fun getWordInfo(): Word
    fun updateWordInfo(word: Word)
    fun getWord(): String
    fun loadWordsInSharedPrefs()
}