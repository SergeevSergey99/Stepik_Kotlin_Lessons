package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    fun CheckInput():Boolean{
        try {
            arg1.text.toString().toInt()
            arg2.text.toString().toInt()
            return true
        }
        catch (e : Exception){

        }
        answer.setText("Input Error")
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener {
            if (CheckInput())
                answer.setText((arg1.text.toString().toInt() + arg2.text.toString().toInt()).toString())
        }
        subtr.setOnClickListener {
            if (CheckInput())
                answer.setText((arg1.text.toString().toInt() - arg2.text.toString().toInt()).toString())
        }

        mul.setOnClickListener {
            if (CheckInput())
                answer.setText((arg1.text.toString().toInt() * arg2.text.toString().toInt()).toString())
        }
        divide.setOnClickListener {
            if (CheckInput())
            {
                if (arg2.text.toString().toInt() == 0)
                    answer.setText("Div by zero")
                else
                    answer.setText((arg1.text.toString().toInt() / arg2.text.toString().toInt()).toString())
            }
        }

    }
}
