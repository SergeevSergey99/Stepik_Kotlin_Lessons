package com.example.company.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button_next2.setOnClickListener {
            val act = Intent(this, ThirdActivity::class.java)
            startActivity(act)
        }
        button_prev2.setOnClickListener {
            val act = Intent(this, MainActivity::class.java)
            startActivity(act)
        }
    }
}
