package com.example.englishguru.app.features.words

import android.content.Context

interface IWordModel {
    fun getWord(): String
    fun increaseDaysForWord(increaseNum: Int)
}