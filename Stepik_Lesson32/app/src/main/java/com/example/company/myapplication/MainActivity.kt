package com.example.company.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    fun spin(size: Int){
        var data = MutableList(size, {x -> "${x+1}"})
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data)
        spinner.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spin(0)

        editText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                try {
                    var len = s.toString().toInt()
                    if(len >= 0)
                        spin(len)
                    else
                        spin(0)
                }catch (e : Exception){
                    spin(0)
                }
            }

        })

    }
}
