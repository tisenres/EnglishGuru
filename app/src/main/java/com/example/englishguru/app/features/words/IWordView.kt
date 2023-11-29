package com.example.englishguru.app.features.words

import com.example.englishguru.data.models.Word

interface IWordView {
    fun showWordTitle(wordStr: String)
    fun fillWordDetails(wordInfo: Word)
    fun showWordDetails()
    fun setUpVisibilityForEmptyCards()
}