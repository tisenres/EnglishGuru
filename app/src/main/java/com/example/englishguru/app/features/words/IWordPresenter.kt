package com.example.englishguru.app.features.words

import android.content.Context

interface IWordPresenter {
    fun getWord(): String
    fun onAgainButtonPressed()
    fun onHardButtonPressed()
    fun onGoodButtonPressed()
    fun onEasyButtonPressed()
}
