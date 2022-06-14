package com.example.company.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    fun countMatches(text: String, template: String): Int {
        var cnt = 0
        var pos = 0
        while (true) {
            pos = text.indexOf(template, pos)
            if (pos != -1) {
                cnt++
                pos++
            } else {
                return cnt
            }
        }
    }
    fun change()
    {
        if(editText.text.contains("question") || editText.text.contains("request") || editText.text.contains("problem")){
            textView.setText((
                countMatches(editText.text.toString(), "question")
                + countMatches(editText.text.toString(), "request")
                + countMatches(editText.text.toString(), "problem")
                + textView.text.toString().toInt()).toString())
            editText.setText(editText.text.toString().replace("question", "answer").replace("request","response").replace("problem", "task"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                    change()
            }

        })

        // Установка обработчика нажатия на кнопку
        button.setOnClickListener{
            // Для создания AlertDialog используется внутренний класс AlertDialog.Builder
            val builder = AlertDialog.Builder(this@MainActivity)

            // Заголовок AlertDialog задаётся при помощи метода setTitle
            builder.setTitle("App background color")

            // Текст AlertDialog задаётся при помощи метода setMessage
            builder.setMessage("Are you want to set the app background color to RED?")

            // Установка текста кнопки соглашения в диалоге и обработчика по нажатию
            builder.setPositiveButton("YES"){dialog, which ->
                // Действия при нажатии кнопки соглашения в диалоге: всплывающее сообщение и смена цвета фона
                Toast.makeText(applicationContext,"Ok, we change the app background.",Toast.LENGTH_SHORT).show()
                root_layout.setBackgroundColor(Color.RED)
            }

            // Установка текста кнопки отказа в диалоге и обработчика по нажатию
            builder.setNegativeButton("No"){dialog,which ->
                Toast.makeText(applicationContext,"You are not agree.",Toast.LENGTH_SHORT).show()
            }

            // Установка текста кнопки отмены в диалоге и обработчика по нажатию
            builder.setNeutralButton("Cancel"){_,_ ->
                Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
            }

            // Создание настроенного экземпляра AlertDialog
            val dialog: AlertDialog = builder.create()

            // Вывод на экран созданного AlertDialog
            dialog.show()
        }
    }
}
