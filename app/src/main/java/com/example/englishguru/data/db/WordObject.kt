package com.example.englishguru.data.db

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

open class WordObject(
    @PrimaryKey
    var word: ObjectId = ObjectId(),
    var dateToShow: String = "",
    var wasShown: Boolean = false,
    var definition: String = "",
    ) : RealmObject
