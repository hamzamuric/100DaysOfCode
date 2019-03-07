package hundreddaysofcode.roomviewmodel

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast

const val EXTRA_TITLE = "hundreddaysofcode.roomviewmodel.EXTRA_TITLE"
const val EXTRA_DESCRIPTION = "hundreddaysofcode.roomviewmodel.EXTRA_DESCRIPTION"
const val EXTRA_PRIORITY = "hundreddaysofcode.roomviewmodel.EXTRA_PRIORITY"

class AddNoteActivity : AppCompatActivity() {

    val editTextTitle by lazy { findViewById<EditText>(R.id.edit_text_title) }
    val editTextDescription by lazy { findViewById<EditText>(R.id.edit_text_description) }
    val numberPickerPriority by lazy { findViewById<NumberPicker>(R.id.number_picker_priority) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        numberPickerPriority.minValue = 1
        numberPickerPriority.maxValue = 10

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)
        title = "Add Note"
    }

    private fun saveNote() {
        val title = editTextTitle.text.toString()
        val description = editTextDescription.text.toString()
        val priority = numberPickerPriority.value

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_TITLE, title)
            putExtra(EXTRA_DESCRIPTION, description)
            putExtra(EXTRA_PRIORITY, priority)
        }

        setResult(RESULT_OK, data)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.save_note -> {
            saveNote()
            true
        }
        else -> super.onContextItemSelected(item)
    }
}
