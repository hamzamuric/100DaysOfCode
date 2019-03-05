package hundreddaysofcode.roomviewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class NoteRepository(application: Application) {

    val _noteDao: NoteDao
    val _allNotes: LiveData<List<Note>>

    init {
        val database = NoteDatabase.getInstance(application)
        _noteDao = database.noteDao()
        _allNotes = _noteDao.getAllNotes()
    }

    @WorkerThread
    fun insert(note: Note) {
        _noteDao.insert(note)
    }

    @WorkerThread
    fun update(note: Note) {
        _noteDao.update(note)
    }

    @WorkerThread
    fun delete(note: Note) {
        _noteDao.delete(note)
    }

    @WorkerThread
    fun deleteAllNotes() {
        _noteDao.deleteAllNotes()
    }

    fun getAllNotes() = _allNotes
}