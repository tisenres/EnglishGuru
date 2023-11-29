//package com.example.englishguru.app.features.vocabularySections
//
//sealed class Section {
//    data class A1(
//        val name: String = "Beginner",
//        val description: String = "Most frequent words in English for A1 level",
//        val numberOfWords: Int = 897,
//        val startWordPos: Int = 0,
//        val endWordPos: Int = 897
//    ) : Section()
//
//    data class A2(
//        val name: String = "Elementary",
//        val description: String = "Description for A2",
//        val numberOfWords: Int = 871,
//        val startWordPos: Int = 898,
//        val endWordPos: Int = 1768
//    ) : Section()
//
//    data class B1(
//        val name: String = "Intermediate",
//        val description: String = "Description for B1",
//        val numberOfWords: Int = 809,
//        val startWordPos: Int = 1769,
//        val endWordPos: Int = 2577
//    ) : Section()
//
//    data class B2(
//        val name: String = "Upper-Intermediate",
//        val description: String = "Description for B2",
//        val numberOfWords: Int = 727,
//        val startWordPos: Int = 2578,
//        val endWordPos: Int = 3304
//    ) : Section()
//
//    data class C1(
//        val name: String = "Advanced",
//        val description: String = "Description for C1",
//        val numberOfWords: Int = 1312,
//        val startWordPos: Int = 3305,
//        val endWordPos: Int = 4616
//    ) : Section()
//}