package hundreddaysofcode.dependencyinjection.car

import android.util.Log
import javax.inject.Inject

class PetrolEngine @Inject constructor() : Engine {
    override fun start() {
        Log.d(TAG, "Petrol engine started")
    }

    companion object {
        const val TAG = "Car"
    }
}