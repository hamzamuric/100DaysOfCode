package hundreddaysofcode.dependencyinjection.car

import android.util.Log
import javax.inject.Inject

class DieselEngine @Inject constructor() : Engine {
    override fun start() {
        Log.d(TAG, "Diesel engine started")
    }

    companion object {
        const val TAG = "Car"
    }
}