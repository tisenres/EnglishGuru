package com.example.englishguru.data.models

import java.util.Date

data class Word (
    val value: String,
    var dateToShow: Date,
    var wasShown: Boolean = false,
    var definition: String
)