package com.example.notesapp

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) { // agr mujhe chahiye ki mera app sirf offline mode se data le na ki online se to mai usme repository use karunga

    // mere app ko aab tension lene ki zarurat nahi hai ki data kha se aayega aab wo repository se ho jaayega


    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}