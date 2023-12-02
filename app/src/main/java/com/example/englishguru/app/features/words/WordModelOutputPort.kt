package com.example.englishguru.app.features.words

import com.example.englishguru.data.models.Word

interface WordModelOutputPort {
    fun onFetchComplete(word: Word)
}
