package com.example.englishguru.features.vocabularySections

interface IVocabularyPresenter {
    fun onButtonPressed(pos: Int)
    fun getSectionName(position: Int): String
    fun getSectionDescription(position: Int): String
    fun getNumberOfWords(position: Int): Int
}