package com.example.sharedviewtransition

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

typealias APair<F, S> = android.util.Pair<F, S>

class MainActivity : AppCompatActivity() {

    val card: CardView by lazy { findViewById<CardView>(R.id.card) }
    val image: ImageView by lazy { findViewById<ImageView>(R.id.imageView) }
    val textName: TextView by lazy { findViewById<TextView>(R.id.text_name) }
    val textAbout: TextView by lazy { findViewById<TextView>(R.id.text_about) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        card.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)

            val pairs = arrayOf<APair<View, String>>(
                APair(image, "imageTransition"),
                APair(textName, "nameTransition"),
                APair(textAbout, "aboutTransition")
            )

            val options = ActivityOptions.makeSceneTransitionAnimation(this, *pairs)

            startActivity(intent, options.toBundle())
        }
    }
}
