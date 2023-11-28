package com.example.englishguru.app.features.words

interface IWordPresenter {
    fun getWord(): String
    fun onAgainButtonPressed()
    fun onHardButtonPressed()
    fun onGoodButtonPressed()
    fun onEasyButtonPressed()
    fun getDefinition(): String
    fun getPartOfSpeech(): String
    fun getSynonyms():  List<String>
    fun getDerivation():  List<String>
    fun getExamples(): List<String>
    fun getSimilarTo(): List<String>
}
