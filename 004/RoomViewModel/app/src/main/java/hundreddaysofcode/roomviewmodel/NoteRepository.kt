package hundreddaysofcode.roomviewmodel

import android.app.Application
import android.os.AsyncTask
import android.support.annotation.WorkerThread

class NoteRepository(application: Application) {

    private val database = NoteDatabase.getInstance(application)
    private val noteDao = database.noteDao()
    private val allNotes = noteDao.getAllNotes()

    @WorkerThread
    fun insert(note: Note) {
        InsertNoteAsyncTask(noteDao).execute(note)
    }

    @WorkerThread
    fun update(note: Note) {
        UpdateNoteAsyncTask(noteDao).execute(note)
    }

    @WorkerThread
    fun delete(note: Note) {
        DeleteNoteAsyncTask(noteDao).execute(note)
    }

    @WorkerThread
    fun deleteAllNotes() {
        DeleteNoteAsyncTask(noteDao).execute()
    }

    fun getAllNotes() = allNotes

    private class InsertNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
        override fun doInBackground(vararg params: Note?) {
            noteDao.insert(params[0]!!)
        }
    }

    private class UpdateNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
        override fun doInBackground(vararg params: Note?) {
            noteDao.update(params[0]!!)
        }
    }

    private class DeleteNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
        override fun doInBackground(vararg params: Note?) {
            noteDao.delete(params[0]!!)
        }
    }

    private class DeleteAllNotesAsyncTask(val noteDao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            noteDao.deleteAllNotes()
        }
    }
}