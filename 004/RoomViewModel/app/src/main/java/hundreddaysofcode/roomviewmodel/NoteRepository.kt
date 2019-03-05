package hundreddaysofcode.roomviewmodel

import android.app.Application
import android.support.annotation.WorkerThread

class NoteRepository(application: Application) {

    private val database = NoteDatabase.getInstance(application)
    private val _noteDao = database.noteDao()
    private val _allNotes = _noteDao.getAllNotes()

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