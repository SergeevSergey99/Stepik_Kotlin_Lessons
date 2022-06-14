package com.example.company.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = MutableList(31, {x -> "$x"})
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)

        gridView.adapter = adapter

        gridView.setOnItemClickListener { parent, view, position, id ->
            adapter.remove( (view as TextView).text.toString())
        }
    }
}
