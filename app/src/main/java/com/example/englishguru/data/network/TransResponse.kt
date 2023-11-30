package com.example.englishguru.data.network

import com.google.gson.annotations.SerializedName

data class TransResponse(
    @SerializedName("data") val data: TranslationData
)

data class TranslationData(
    @SerializedName("translations") val translations: List<Translation>
)

data class Translation(
    @SerializedName("translatedText") val translatedText: String
)
