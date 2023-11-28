//package com.example.englishguru.data
//
//import com.example.englishguru.data.db.WordDao
//import com.example.englishguru.data.db.WordDto
//import com.example.englishguru.data.models.Word
//
//class DBRepository {
//
//    private val wordDao: WordDao = WordDao()
//
//    fun getWordInfo(word: Word): Word? {
//        val wordDto = wordDao.getWordInfo(word.word)
//        return wordDto?.let {
//             Word(
//                word = it.word,
//                dateToShow = it.dateToShow,
//                wasShown = it.wasShown,
//                definition = it.definition
//            )
//        }
//    }
//
//    fun updateWordInfo(word: Word) {
//        val wordDto = WordDto(
//
//        )
//        wordDao.updateWord(wordDto)
//    }
//
//    fun saveWordInDB(word: Word) {
////        val wordDto = WordDto(
////            word.word,
////            word.dateToShow,
////            word.wasShown,
////            word.definition
////        )
////        wordDao.saveWord()
//    }
//
//}