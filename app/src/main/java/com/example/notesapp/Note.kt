package com.example.notesapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table") // ye basicaly table banane ke help mai aayegi
class Note (@ColumnInfo(name  = "text") val text:String){ // isse column ban jaayege aur itne hi banege jitne hum likhenge
    @PrimaryKey(autoGenerate = true) var id = 0

}  // ye hamari table baan gayi