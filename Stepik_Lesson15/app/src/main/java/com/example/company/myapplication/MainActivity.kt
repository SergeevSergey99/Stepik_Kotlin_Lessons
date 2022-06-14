package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBtn.setOnClickListener {
            try {


            val num = editText.text.toString().toInt()
            if (num >= 2) {
                for (i in 2 until num) {
                    if (num % i == 0)
                    {
                        textView.setText("not prime")
                        return@setOnClickListener
                    }
                }
                textView.setText("prime")
            }
            else{
                textView.setText("not prime")
            }
            }catch (e : Exception){
                textView.setText("error")
            }
        }

    }
}
