package hundreddaysofcode.roomviewmodel

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.support.annotation.WorkerThread

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        lateinit var instance: NoteDatabase

        fun getInstance(context: Context): NoteDatabase {
            synchronized(this) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        NoteDatabase::class.java, "note_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
                return instance
            }
        }

        val roomCallback = object : RoomDatabase.Callback() {

            @WorkerThread
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                (db as NoteDatabase).noteDao().apply {
                    insert(Note("Title 1", "Description 1", 1))
                    insert(Note("Title 2", "Description 2", 2))
                    insert(Note("Title 3", "Description 3", 3))
                }
            }
        }
    }
}