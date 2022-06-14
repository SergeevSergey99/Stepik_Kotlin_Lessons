package com.example.company.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        button.setOnClickListener {
            val url = editText.text.toString()

// Request a string response from the provided URL.
            val stringRequest = StringRequest(Request.Method.GET, url, { response ->
                textView.setText("Ok")
                }, { textView.text = "Failed" })
            queue.add(stringRequest)
        }
    }
}
