package hundreddaysofcode.roomviewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NoteRepository(application)
    private val allNotes = repository.getAllNotes()

    fun insert(note: Note) = repository.insert(note)

    fun update(note: Note) = repository.update(note)

    fun delete(note: Note) = repository.delete(note)

    fun deleteAllNotes() = repository.deleteAllNotes()

    fun getAllNotes() = repository.getAllNotes()
}