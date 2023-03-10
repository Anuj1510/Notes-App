package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INotesRVAdapter {

    lateinit var viewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this, this)
        RecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,    // viewmodelprovider basically saare viewmodel ko main activity se attach kr dega
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this,Observer{list ->
            list?.let{
                adapter.updateList(it)
            }
        })

    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_LONG).show()

    }

    fun SubmitData(view: View) {
        val noteText = input.text.toString()
        if(noteText.isNotEmpty()) {
            viewModel.insertNote(Note(noteText))
            Toast.makeText(this,"${noteText} Inserted",Toast.LENGTH_LONG).show()
            input.text.clear()
        }

    }
}