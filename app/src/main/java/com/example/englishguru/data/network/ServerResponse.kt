package com.example.englishguru.data.network

data class WordResponse(
    val word: String,
    val results: List<WordResult>,
    val syllables: Syllables,
    val pronunciation: Pronunciation,
    val frequency: Double
)

data class WordResult(
    val definition: String,
    val partOfSpeech: String?,
    val synonyms: List<String>,
    val similarTo: List<String>,
    val derivation: List<String>? = null,
    val examples: List<String>,
    val typeOf: List<String>? = null,
    val inCategory: List<String>? = null,
    val antonyms: List<String>? = null
)

data class Syllables(
    val count: Int,
    val list: List<String>
)

data class Pronunciation(
    val all: String
)

