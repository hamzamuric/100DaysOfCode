package com.hart.onoff

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val onBtn by lazy { findViewById<Button>(R.id.button_on) }
    val offBtn by lazy { findViewById<Button>(R.id.button_off) }
    val urlEditText by lazy { findViewById<EditText>(R.id.edit_text_url) }
    val urlSubmitBtn by lazy { findViewById<Button>(R.id.button_url_submit) }

    lateinit var onOff: OnOffApi

    val gson = GsonBuilder().setLenient().create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onBtn.setOnClickListener(::turnOn)
        offBtn.setOnClickListener(::turnOff)

        urlSubmitBtn.setOnClickListener {
            val url = urlEditText.text.toString()
            createRetrofit(url)
        }

        createRetrofit("http://192.168.1.13:5000")
    }

    fun createRetrofit(url: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        onOff = retrofit.create(OnOffApi::class.java)
    }

    fun turnOn(v: View) = onOff.turnOn().enqueue(emptyCallback)

    fun turnOff(v: View) = onOff.turnOff().enqueue(emptyCallback)

    val emptyCallback = object : Callback<String> {
        override fun onFailure(call: Call<String>, t: Throwable) = Unit
        override fun onResponse(call: Call<String>, response: Response<String>) = Unit
    }
}
