package com.example.englishguru.app.features.words

import com.example.englishguru.data.IRepository
import com.example.englishguru.data.Repository

class WordModel: IWordModel {

    private val repository: IRepository = Repository()

    override fun getWord(): String {
        return repository.getWord()
    }
}