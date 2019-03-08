package hundreddaysofcode.roomviewmodel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    var notes: List<Note> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onClickListener: ((Note) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.apply {
            textViewTitle.text = notes[position].title
            textViewDescription.text = notes[position].description
            textViewPriority.text = notes[position].priority.toString()
        }
    }

    override fun getItemCount() = notes.size

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle = itemView.findViewById<TextView>(R.id.text_view_title)
        val textViewDescription = itemView.findViewById<TextView>(R.id.text_view_description)
        val textViewPriority = itemView.findViewById<TextView>(R.id.text_view_priority)

        init {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onClickListener?.invoke(notes[adapterPosition])
            }
        }
    }
}