package com.example.englishguru.features.translator.models

enum class LanguageModel(val languageName: String, val languageCode: String) {
    English("English", "en"),
    Russian("Russian", "ru"),
    German("German", "de"),
    Uzbek("Uzbek", "uz"),
    French("French", "fr"),
    Spain("Spain", "es"),
    Hindi("Hindi", "hi"),
    Turkish("Turkish", "tr"),
    Ukrainian("Ukrainian", "uk"),
    Czech("Czech", "cs");

    companion object {
        fun getLanguageCodeByName(languageName: String): String {
            return values().find { it.languageName == languageName }?.languageCode ?: ""
        }

        fun getLanguageNameByCode(languageCode: String): String {
            return values().find { it.languageCode == languageCode }?.languageName ?: ""
        }
    }
}
