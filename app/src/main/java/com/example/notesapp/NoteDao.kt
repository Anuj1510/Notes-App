package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // IGNORE use karne ki wajha se agr same data waapis dalne ka try karenge to wo ignore ho jaayega
    fun insert(note: Note)  // suspend hum unn functions pr use krte jo hum background mai run krane hone hote hai app ke aur takki wo jayda load na le isliye hum suspend use krte hai


    @Delete
    fun delete(note: Note)


    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Note>> // livedata use krke hum apne data pe jisse hum store kr rahe hai uspe nazar rakh sakte hai

}