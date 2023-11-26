package com.example.englishguru.data.models

import java.time.LocalDateTime

data class Word (
    val value: String,
    var dateToShow: Int = LocalDateTime.now().dayOfYear,
    var wasShown: Boolean = false,
    var definition: String = ""
)