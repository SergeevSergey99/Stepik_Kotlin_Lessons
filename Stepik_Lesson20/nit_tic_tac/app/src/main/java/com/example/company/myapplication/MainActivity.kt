package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    var winX = false
    var win0 = false

    fun calcWin(arr: Array<Array<Spinner>>, i:Int, j:Int, stepX:Int, stepY: Int){
        var cnt = 0

        val curr = arr[i][j].selectedItem.toString()
        for (k in 0 until arr.size) {
            if(i + stepX * k >= 0 && i + stepX * k < arr.size && j + stepY * k >= 0 && j + stepY * k < arr.size)
                if(arr[i+ stepX * k][j + stepY * k].selectedItem.toString().equals(curr))
                    cnt++
        }

        if (cnt == 3)
        {
            if(curr.equals("X"))
                winX = true
            else if (curr.equals("0"))
                win0 = true
        }

    }
    fun Check(arr: Array<Array<Spinner>>) {
        var cntX = 0
        var cnt0 = 0
        winX = false
        win0 = false
        for (i in 0 until arr.size) {
            for (j in 0 until arr[i].size) {
                val curr = arr[i][j].selectedItem.toString()
                if (curr.equals("X"))
                    cntX++;
                else if (curr.equals("0"))
                    cnt0++;



                calcWin(arr,i,j,1,0)
                calcWin(arr,i,j,0,1)
                calcWin(arr,i,j,1,1)
                calcWin(arr,i,j,1,-1)


            }
        }

        if (abs(cntX - cnt0) > 1 || (winX && win0)) {
            status.text = "Invalid"
        } else {
            if (winX)
                status.text = "X won"
            else if (win0)
                status.text = "0 won"
            else if (cntX + cnt0 == arr.size * arr.size)
                status.text = "Draw"
            else
                status.text = ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var array = arrayOf(
            arrayOf(spinner11, spinner12, spinner13),
            arrayOf(spinner21, spinner22, spinner23),
            arrayOf(spinner31, spinner32, spinner33)
        )

        for (row in array) {
            for (item in row) {
                item.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        Check(array)
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }

                })

            }
        }

        Check(array)

    }
}
