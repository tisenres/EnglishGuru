package com.example.englishguru.app.features.words

import com.example.englishguru.data.models.Word

interface OutputPortModel {
    fun onFetchComplete(word: Word)
}
