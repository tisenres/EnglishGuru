package com.example.englishguru.features.translator

interface TransModelOutputPort {
    fun onFetchComplete(response: String)
}
