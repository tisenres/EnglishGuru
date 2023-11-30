package com.example.englishguru.data.network

import com.google.gson.annotations.SerializedName

data class TransResponse(
    @SerializedName("translations") val translations: List<Translation>
)

data class Translation(
    @SerializedName("text") val text: String
)
