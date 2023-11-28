package com.example.englishguru.app.features.words

import com.example.englishguru.data.models.Word

interface IWordPresenter {
    fun getWord(): String
    fun onAgainButtonPressed()
    fun onHardButtonPressed()
    fun onGoodButtonPressed()
    fun onEasyButtonPressed()
}
