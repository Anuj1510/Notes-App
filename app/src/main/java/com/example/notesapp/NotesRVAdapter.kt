package com.example.notesapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: INotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    val allNotes = ArrayList<Note>()

    inner class  NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deletebutton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder { // ye data banata hai
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_node, parent ,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) { // ye data ko bind karke rakhta hai
        val currentNode = allNotes[position]
        holder.textView.text = currentNode.text
    }

    override fun getItemCount(): Int { // ye data ko count karta hai
        return allNotes.size
    }

    fun updateList(newlist: List<Note>){
        allNotes.clear()
        allNotes.addAll(newlist)

        notifyDataSetChanged() // list apne aap update ho jaayegi
    }
}

interface INotesRVAdapter{
    fun onItemClicked(note: Note)
}