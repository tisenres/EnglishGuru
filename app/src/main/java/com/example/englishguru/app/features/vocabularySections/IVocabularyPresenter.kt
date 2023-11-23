package com.example.englishguru.app.features.vocabularySections

interface IVocabularyPresenter {
    fun onButtonPressed(pos: Int)
    fun getSectionName(position: Int): String
    fun getSectionDescription(position: Int): String
    fun getNumberOfWords(position: Int): Int
}