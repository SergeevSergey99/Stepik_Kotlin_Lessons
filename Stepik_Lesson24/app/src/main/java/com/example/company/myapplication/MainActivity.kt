package com.example.company.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            var act = Intent(this, SecondActivity::class.java)
            startActivity(act)
        }
    }

    override fun onResume() {
        super.onResume()

        textView.text = editText.text
        editText.setText("")
    }
}
