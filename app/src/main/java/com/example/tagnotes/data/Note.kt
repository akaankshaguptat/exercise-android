package com.example.tagnotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(

    var name: String,

    var email: String,

    var phone: String
) {

    //does it matter if these are private or not?
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}