package com.example.tagnotes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tagnotes.R
import com.example.tagnotes.data.Note
import com.example.tagnotes.databinding.NoteItemBinding
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.name == newItem.name && oldItem.email == newItem.email
                        && oldItem.phone == newItem.phone
            }
        }
    }

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding:NoteItemBinding=DataBindingUtil.inflate(inflater,R.layout.note_item,parent,false)
        //val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
       // return NoteHolder(itemView)
       return NoteHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote: Note = getItem(position)

//        holder.textViewName.text = currentNote.name
//        holder.textViewPhone.text = currentNote.phone
//        holder.textViewEmail.text = currentNote.email
        holder.binding.note=currentNote
        holder.binding.executePendingBindings()

    }

    fun getNoteAt(position: Int): Note {
        return getItem(position)
    }

//    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {
//            itemView.setOnClickListener {
//                val position = adapterPosition
//                if (position != RecyclerView.NO_POSITION) {
//                    listener?.onItemClick(getItem(position))
//                }
//            }
//        }
//
//        var textViewName: TextView = itemView.text_view_name
//        var textViewPhone: TextView = itemView.text_view_phone
//        var textViewEmail: TextView = itemView.text_view_email
//    }
    inner class NoteHolder(var binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickListener {
        fun onItemClick(note: Note)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}
