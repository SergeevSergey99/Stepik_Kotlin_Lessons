package com.example.company.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        convertButton.setOnClickListener {
            try {
                convertResult.setText(number.text.toString().toInt().toString(systemOfCalculus.text.toString().toInt()))
            } catch (e: Exception) {
                convertResult.setText("Error")
            }
        }
    }
}
