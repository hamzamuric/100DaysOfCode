package hundreddaysofcode.roomviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem

const val ADD_NOTE_REQUEST = 1
const val EDIT_NOTE_REQUEST = 2

class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddNote = findViewById<FloatingActionButton>(R.id.button_add_note)
        buttonAddNote.setOnClickListener {
            val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java)
            startActivityForResult(intent, ADD_NOTE_REQUEST)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val adapter = NoteAdapter()
        recyclerView.adapter = adapter

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.getAllNotes().observe(this, Observer { notes ->
            if (notes != null)
                adapter.submitList(notes)
        })

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHoler1: RecyclerView.ViewHolder,
                viewHolder2: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                noteViewModel.delete(adapter.getNoteAt(viewHolder.adapterPosition))
                this@MainActivity.toast("Note deleted")
            }
        }).attachToRecyclerView(recyclerView)

        adapter.onClickListener = { note ->
            val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java).apply {
                putExtra(EXTRA_ID, note.id)
                putExtra(EXTRA_TITLE, note.title)
                putExtra(EXTRA_DESCRIPTION, note.description)
                putExtra(EXTRA_PRIORITY, note.priority)
            }
            startActivityForResult(intent, EDIT_NOTE_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null || resultCode != RESULT_OK) {
            toast("Note not saved")
            return
        }

        val title = data.getStringExtra(EXTRA_TITLE)
        val description = data.getStringExtra(EXTRA_DESCRIPTION)
        val priority = data.getIntExtra(EXTRA_PRIORITY, 1)

        when (requestCode) {
            ADD_NOTE_REQUEST -> {
                val note = Note(title, description, priority)
                noteViewModel.insert(note)
                toast("Note Saved")
            }
            EDIT_NOTE_REQUEST -> {
                val id = data.getIntExtra(EXTRA_ID, -1)
                if (id == -1) {
                    toast("Note can't be updated")
                    return
                }

                val note = Note(title, description, priority)
                note.id = id

                noteViewModel.update(note)
                toast("Note updated")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.delete_all_notes -> {
            noteViewModel.deleteAllNotes()
            toast("All notes deleted")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }


}
