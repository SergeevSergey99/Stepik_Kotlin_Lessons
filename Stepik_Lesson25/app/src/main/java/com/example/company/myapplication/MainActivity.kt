package com.example.company.myapplication

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_item.*
import kotlinx.android.synthetic.main.activity_list_item.view.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataArray = arrayOf("1", "2", "3")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataArray)
        listView1.adapter = adapter

        listView1.setOnItemClickListener { adapterView, view, i, l ->
            var act = Intent(this, ListItemActivity::class.java)
            act.putExtra("text", (view as TextView).text.toString())
            startActivity(act)
        }
    }
}
