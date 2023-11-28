package com.example.englishguru.app.features.words

import com.example.englishguru.data.models.Word

interface IWordModel {
    fun assignRandomWord()
    fun getWord(): String
    fun increaseDaysForWord(increaseNum: Int)
    fun getWordInfo(): Word
    fun fetchWordDataRemotely()
    fun onDestroyView()
}