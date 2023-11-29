package com.example.englishguru.app.features.vocabularySections.models

sealed class Section(
    open var name: String,
    open var description: String,
    open val numberOfWords: Int,
    open val startWordPos: Int,
    open val endWordPos: Int
) {
    data class A1(
        override var name: String = "Beginner",
        override var description: String = "Most frequent words used in every conversation",
        override var numberOfWords: Int = 897,
        override var startWordPos: Int = 0,
        override var endWordPos: Int = 897
    ): Section(name, description, numberOfWords, startWordPos, endWordPos)

    data class A2(
        override var name: String = "Elementary",
        override var description: String = "Best suits for everyday talks and tourism",
        override var numberOfWords: Int = 871,
        override var startWordPos: Int = 898,
        override var endWordPos: Int = 1768
    ): Section(name, description, numberOfWords, startWordPos, endWordPos)

    data class B1(
        override var name: String = "Intermediate",
        override var description: String = "Independent user who can understand the main points of clear texts on familiar topics in standard language",
        override var numberOfWords: Int = 809,
        override var startWordPos: Int = 1769,
        override var endWordPos: Int = 2577
    ) : Section(name, description, numberOfWords, startWordPos, endWordPos)

    data class B2(
        override var name: String = "Upper-Intermediate",
        override var description: String = "Description for B2",
        override var numberOfWords: Int = 727,
        override var startWordPos: Int = 2578,
        override var endWordPos: Int = 3304
    ) : Section(name, description, numberOfWords, startWordPos, endWordPos)

    data class C1(
        override var name: String = "Advanced",
        override var description: String = "Advanced vocabulary for real English Guru's!",
        override var numberOfWords: Int = 1312,
        override var startWordPos: Int = 3305,
        override var endWordPos: Int = 4616
    ) : Section(name, description, numberOfWords, startWordPos, endWordPos)
}