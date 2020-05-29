package alistar.androidcleanarchitecture.ui.screens.mainactivity

import alistar.androidcleanarchitecture.databinding.NoteListItemBinding
import alistar.core.domain.entities.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NotesAdapter.Holder>() {

    class Holder(private val binding: NoteListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.note = note
            binding.executePendingBindings()
        }

        companion object {
            fun from(viewGroup: ViewGroup): Holder {
                val inflater = LayoutInflater.from(viewGroup.context)
                val binding = NoteListItemBinding.inflate(inflater, viewGroup, false)
                return Holder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder.from(parent)

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(notes[position])
    }

}