package com.example.myapplication8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
// hello
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMeme()

    }

    private fun loadMeme(){

    // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = " https://meme-api.com/gimme"


        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val url = response.getString("url")

                val imageMeme=findViewById<ImageView>(R.id.memeImageView)
                Glide.with(this).load(url).into(imageMeme)
            },

            Response.ErrorListener{
                Toast.makeText(this, "Something Error", Toast.LENGTH_SHORT).show()
            })

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }

    fun nextMeme(view: View) {

    }
    fun shareMeme(view: View) {

    }
}