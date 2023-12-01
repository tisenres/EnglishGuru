package com.example.englishguru.app.features.translator

interface TransModelOutputPort {
    fun onFetchComplete(response: String)
}
