/* viewmodel basicaly data hold karke rakhta hai. For example jub hum phone ko portrait se landscape mode pe late hai
to phele jo activity bani hai wo distroy hoti hai aur ekk new activity recreate hoti hai to humme apne data ko hold
krne ke liye matlab jub phone portrait se landscape mode main jai tub activity distroy hoke recreate ho tub data
lost naa ho jaaye*/

package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {


    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }

}