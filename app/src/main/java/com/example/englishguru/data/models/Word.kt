package com.example.englishguru.data.models

data class Word (
    val word: String = "",
//    var dateToShow: Int = LocalDateTime.now().dayOfYear,
//    var wasShown: Boolean = false,
    var definition: String = "",
    var partOfSpeech: String = "",
    var synonyms: List<String> = emptyList(),
    var derivation: List<String> = emptyList(),
    var examples: List<String> = emptyList(),
    var similarTo: List<String> = emptyList()
)