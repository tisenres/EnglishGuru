//package com.example.englishguru.data.db
//
//import io.realm.kotlin.Realm
//import io.realm.kotlin.RealmConfiguration
//import io.realm.kotlin.ext.query
//
//class WordDao {
//    private val config = RealmConfiguration.create(schema = setOf(WordDto::class))
//    val realm: Realm = Realm.open(config)
//
//    fun updateWord(wordDto: WordDto) {
//        realm.writeBlocking {
//            copyToRealm(WordDto().apply {
//                word = wordDto.word
//                dateToShow = wordDto.dateToShow
//                wasShown = wordDto.wasShown
//                definition = wordDto.definition
//                frequency = wordDto.frequency
//            })
//        }
//    }
//
//    fun getWordInfo(word: String): WordDto? {
//        return realm.query<WordDto>("word = $0", word).first().find()
//    }
//}