package hundreddaysofcode.senddatatofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ExampleFragment.newInstance("example text", 123)

        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
