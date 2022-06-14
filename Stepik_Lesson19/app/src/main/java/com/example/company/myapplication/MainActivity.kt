package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var saveSlot = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    var str = editText.text.toString().replace("[^\\w\\p{InCyrillic} ]".toRegex(), " ").trim().replace(" +".toRegex(), " ")
                    val v = str.split(' ').count()
                    if(v > 10)
                    {
                        str = str
                    }

                    if (str.equals(""))
                        stats_view.text = "0"
                    else
                        stats_view.text = str.split(' ').count().toString()

                    if(s.toString().equals(saveSlot))
                        unsaved_changes_view.text = "All changes saved"
                    else
                        unsaved_changes_view.text = "Unsaved changes"
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        save_button.setOnClickListener {
            saveSlot = editText.text.toString()

            unsaved_changes_view.text = "All changes saved"
        }
        clear_button.setOnClickListener {
            editText.setText("")
        }
        load_button.setOnClickListener {
            editText.setText(saveSlot)

            unsaved_changes_view.text = "All changes saved"
        }
    }
}
