package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity()
{
    private var text_string: String = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // кнопочка 0
        val zeroButton = findViewById<Button>(R.id.zero_button)
        zeroButton.setOnClickListener {
            text_string += "0"
            ChangeText()
        }

        // кнопочка 1
        val oneButton = findViewById<Button>(R.id.one_button)
        oneButton.setOnClickListener {
            text_string += "1"
            ChangeText()
        }

        // кнопочка 2
        val twoButton = findViewById<Button>(R.id.two_button)
        twoButton.setOnClickListener {
            text_string += "2"
            ChangeText()
        }

        // кнопочка 3
        val threeButton = findViewById<Button>(R.id.three_button)
        threeButton.setOnClickListener {
            text_string += "3"
            ChangeText()
        }

        // кнопочка 4
        val fourButton = findViewById<Button>(R.id.four_button)
        fourButton.setOnClickListener {
            text_string += "4"
            ChangeText()
        }

        // кнопочка 5
        val fiveButton = findViewById<Button>(R.id.five_button)
        fiveButton.setOnClickListener {
            text_string += "5"
            ChangeText()
        }
        // кнопочка 6
        val sixButton = findViewById<Button>(R.id.six_button)
        sixButton.setOnClickListener {
            text_string += "6"
            ChangeText()
        }

        // кнопочка 7
        val sevenButton = findViewById<Button>(R.id.seven_button)
        sevenButton.setOnClickListener {
            text_string += "7"
            ChangeText()
        }

        // кнопочка 8
        val eightButton = findViewById<Button>(R.id.eight_button)
        eightButton.setOnClickListener {
            text_string += "8"
            ChangeText()
        }

        // кнопочка 9
        val nineButton = findViewById<Button>(R.id.nine_button)
        nineButton.setOnClickListener {
            text_string += "9"
            ChangeText()
        }

        // кнопочка очистить
        val clearButton = findViewById<Button>(R.id.clear_button)
        clearButton.setOnClickListener {
            text_string = ""
            ChangeText()
        }

        // кнопочка левая скобка
        val leftBrucketButton = findViewById<Button>(R.id.left_bracket_button)
        leftBrucketButton.setOnClickListener {
            text_string += "("
            ChangeText()
        }

        // кнопочка правая скобка
        val rightBrucketButton = findViewById<Button>(R.id.right_bracket_button)
        rightBrucketButton.setOnClickListener {
            text_string += ")"
            ChangeText()
        }

        // кнопочка процент
        val percentButton = findViewById<Button>(R.id.percent_button)
        percentButton.setOnClickListener {
            text_string += "%"
            ChangeText()
        }

        // кнопочка делить
        val divideButton = findViewById<Button>(R.id.divide_button)
        divideButton.setOnClickListener {
            text_string += "/"
            ChangeText()
        }

        // кнопочка умножить
        val multiplyButton = findViewById<Button>(R.id.multiply_button)
        multiplyButton.setOnClickListener {
            text_string += "*"
            ChangeText()
        }

        // кнопочка вычесть
        val minusButton = findViewById<Button>(R.id.minus_button)
        minusButton.setOnClickListener {
            text_string += "-"
            ChangeText()
        }

        // кнопочка прибавить
        val addButton = findViewById<Button>(R.id.add_button)
        addButton.setOnClickListener {
            text_string += "+"
            ChangeText()
        }

        // кнопочка запятая
        val commmaButton = findViewById<Button>(R.id.comma_button)
        commmaButton.setOnClickListener {
            text_string += ","
            ChangeText()
        }

        // кнопочка назад
        val backButton = findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            if (text_string.length > 0)
            {
                text_string = text_string.substring(0, text_string.length-1)
                ChangeText()
            }
        }

        // кнопочка равно
        val equalsButton = findViewById<Button>(R.id.equals_button)
        equalsButton.setOnClickListener {
            try
            {
                text_string = ExpressionBuilder(text_string.replace(",",".")).build().evaluate().toString()
            }
            catch (e: Exception)
            {

                text_string = ""
            }
            ChangeText()
        }
    }

    // метод изменения текста в текст блоке
    private fun ChangeText()
    {
        val main_text: TextView = findViewById(R.id.main_text)
        main_text.text = text_string
    }
}