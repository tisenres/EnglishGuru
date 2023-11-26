package com.example.englishguru.app.features.words

interface IWordModel {
    fun getWord(): String
    fun increaseDaysForWord(increaseNum: Int)
    fun loadAllWords()
}