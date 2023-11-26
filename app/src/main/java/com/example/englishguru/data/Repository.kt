package com.example.englishguru.data

import com.example.englishguru.data.db.WordObject
import com.example.englishguru.data.models.Word
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import java.util.Date

class Repository: IRepository {

    private val testStorage = mutableListOf<Word>()
    private val config = RealmConfiguration.create(schema = setOf(WordObject::class))
    val realm: Realm = Realm.open(config)

    override fun getWordInfo(): Word {

        val items: RealmResults<WordObject> = realm.query<WordObject>().find()
        items.forEach {
            println(it.word)
        }

        return Word(items.random().word.toString(), Date())
//        val filter = testStorage.filter {
//            it.dateToShow.day == Date().day
//        }
//
//        val numberOfWordsShown = filter.count { it.wasShown }
//
//        return if (numberOfWordsShown == 0) {
//            filter.shuffled().first()
//        } else {
//            filter.shuffled().first {
//                it.wasShown
//            }
//        }
    }

    override fun updateWord(word: Word) {
//        testStorage.filter {
//            it == word
//        }.map {
//            it.dateToShow = word.dateToShow
//            it.wasShown = word.wasShown
//        }
    }
}