package com.example.englishguru.features.words

import com.example.englishguru.data.models.Word

interface WordModelOutputPort {
    fun onFetchComplete(word: Word)
}
