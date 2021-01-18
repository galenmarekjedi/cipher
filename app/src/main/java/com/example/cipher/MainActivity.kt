package com.example.cipher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var length = 0

        fun smallLetters() {
            var chartmp = Random.nextInt(97, 122).toChar()
            tvPasswd.text = tvPasswd.text.toString() + chartmp.toString()
        }

        fun capitalLetters() {

            var chartmp = Random.nextInt(65, 90).toChar()
            tvPasswd.text = tvPasswd.text.toString() + chartmp.toString()

        }

        fun digits() {
            var chartmp = Random.nextInt(48, 57).toChar()
            tvPasswd.text = tvPasswd.text.toString() + chartmp.toString()
        }

        fun specChars() {
            val chartmp = listOf<Char>('!', '#', '$', '%', '@','&','*','/','?')
            val randChar = chartmp.random()
            tvPasswd.text = tvPasswd.text.toString() + randChar.toString()
        }

        val checkboxList = listOf(sletters, cletters,digits, specChar)

        generate.setOnClickListener {
            if (etpassLenght.text.length == 0) {
                length = 0
                tvErr.visibility = VISIBLE
            } else {
                length = etpassLenght.text.toString().toInt()
                tvErr.visibility = INVISIBLE
            }
            tvPasswd.text = ""

            val filteredList: List<CheckBox> = checkboxList.filter { it.isChecked }

            if(filteredList.isEmpty()){
                tvPasswd.text = "No element selected, select at least one"
            } else {

                for (i in 0 until length) {
                    when (filteredList.random()) {
                        sletters -> smallLetters()
                        cletters -> capitalLetters()
                        digits -> digits()
                        specChar -> specChars()
                        else -> tvPasswd.text = "No element selected"
                    }
                }
            }
            tvPasswd.visibility = VISIBLE
        }
    }

}
