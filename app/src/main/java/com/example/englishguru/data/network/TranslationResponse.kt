package com.example.englishguru.data.network

data class TranslationResponse(
    val translations: List<Translation>,
)

data class Translation (
    val translated: List<String>
)
