//package com.example.englishguru.data.db
//
//import io.realm.kotlin.types.RealmObject
//import io.realm.kotlin.types.annotations.PrimaryKey
//import org.mongodb.kbson.ObjectId
//import java.time.LocalDate
//import java.time.LocalDateTime
//import java.util.Calendar
//
//class WordDto() : RealmObject {
//    @PrimaryKey
//    var _id: ObjectId = ObjectId()
//    var word: String = ""
//    var dateToShow: Int = LocalDateTime.now().dayOfYear
//    var wasShown: Boolean = false
//    var definition: String = ""
//    var frequency: Double = 0.0
//}
