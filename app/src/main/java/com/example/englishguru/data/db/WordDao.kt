package com.example.englishguru.data.db

import android.util.Log
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import java.time.LocalDateTime

class WordDao {
    private val config = RealmConfiguration.create(schema = setOf(WordDto::class))
    val realm: Realm = Realm.open(config)

    fun updateWord(wordDto: WordDto) {
        realm.writeBlocking {
            copyToRealm(WordDto().apply {
                word = wordDto.word
                dateToShow = wordDto.dateToShow
                wasShown = wordDto.wasShown
                definition = wordDto.definition
                frequency = wordDto.frequency
            })
        }
    }

    fun getWord(): WordDto {

        val todayDate = LocalDateTime.now().dayOfYear

        val items: RealmResults<WordDto> = realm.query<WordDto>().find()

        items.forEach {
            if (it.dateToShow == todayDate) {
                Log.d("SDYSTDYTSD", "YEYTSDTYSTYDTYSD")
            }
        }

        return items.first()

    }
}