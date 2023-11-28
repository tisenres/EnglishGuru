package com.example.englishguru.app.features.words

interface IWordPresenter {
    fun getWord(): String
    fun onAgainButtonPressed()
    fun onHardButtonPressed()
    fun onGoodButtonPressed()
    fun onEasyButtonPressed()
    fun getWordDefinition(): String
}
