package hundreddaysofcode.roomviewmodel

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(old: Note, new: Note) =
        old.id == new.id

    override fun areContentsTheSame(old: Note, new: Note) =
        old.title == new.title &&
        old.description == new.description &&
        old.priority == new.priority
}

class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteHolder>(DIFF_CALLBACK) {

    var onClickListener: ((Note) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = getItem(position)
        holder.apply {
            textViewTitle.text = currentNote.title
            textViewDescription.text = currentNote.description
            textViewPriority.text = currentNote.priority.toString()
        }
    }

    fun getNoteAt(position: Int) = getItem(position)

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle = itemView.findViewById<TextView>(R.id.text_view_title)
        val textViewDescription = itemView.findViewById<TextView>(R.id.text_view_description)
        val textViewPriority = itemView.findViewById<TextView>(R.id.text_view_priority)

        init {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onClickListener?.invoke(getItem(adapterPosition))
            }
        }
    }
}