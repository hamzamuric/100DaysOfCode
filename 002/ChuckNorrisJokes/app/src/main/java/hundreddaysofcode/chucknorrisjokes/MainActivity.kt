package hundreddaysofcode.chucknorrisjokes

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.constraint.ConstraintLayout
import android.support.v4.widget.SwipeRefreshLayout
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    val colors = listOf("#CDDC39", "#FFEB3B", "#673AB7", "#2196F3",
            "#F44336", "#E91E63", "#FF5722")

    var currentColor: String = ""

    val jokeTextView by lazy { findViewById<TextView>(R.id.joke_text) }
    val background by lazy { findViewById<ConstraintLayout>(R.id.constraint_layout) }
    val refreshLayout by lazy { findViewById<SwipeRefreshLayout>(R.id.refresh_layout) }

    val callback = object : Callback<Joke> {

        override fun onFailure(call: Call<Joke>, t: Throwable) {
            jokeTextView.text = "No internet connection"
            jokeTextView.setTextColor(Color.WHITE)
            background.setBackgroundColor(Color.RED)
        }

        override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
            if (!response.isSuccessful) return

            val jokeText = response.body().toString()
            jokeTextView.text = jokeText
            jokeTextView.setTextColor(Color.BLACK)

            currentColor = colors.random()
            background.setBackgroundColor(Color.parseColor(currentColor))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io")
                .build()

        val jokesApi = retrofit.create(JokesApi::class.java)
        jokesApi.getJoke().enqueue(callback)

        refreshLayout.setOnRefreshListener {
            jokesApi.getJoke().enqueue(callback)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState?.putString("joke", jokeTextView.text.toString())
        outState?.putString("color", currentColor)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        val joke = savedInstanceState?.getString("joke") ?: "No internet connection"
        jokeTextView.text = joke

        val color = savedInstanceState?.getString("color") ?: "#FF0000"
        background.setBackgroundColor(Color.parseColor(color))
    }
}
