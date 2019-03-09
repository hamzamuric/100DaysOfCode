package hundreddaysofcode.dependencyinjection

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(val engine: Engine, val wheels: Wheels) {

    fun drive() {
        Log.d(TAG, "driving")
    }

    companion object {
        private const val TAG = "Car"
    }
}