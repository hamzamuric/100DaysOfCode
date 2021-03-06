package hundreddaysofcode.dependencyinjection.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hundreddaysofcode.dependencyinjection.DaggerCarComponent
import hundreddaysofcode.dependencyinjection.R
import hundreddaysofcode.dependencyinjection.car.Car
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerCarComponent.create()
        component.inject(this)

        car.drive()
    }
}
