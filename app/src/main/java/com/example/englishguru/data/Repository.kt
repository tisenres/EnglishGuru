package com.example.englishguru.data

class Repository: IRepository {

    private val testStorage = mutableListOf("Test1", "Test2", "Test3")

    override fun getWord(): String {
        return testStorage[0]
    }
}