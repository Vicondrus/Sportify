package com.uid.project.sportify

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class VerificationCodeActivity : AppCompatActivity(){
    private lateinit var nextButton : Button
    private lateinit var textView1 : EditText
    private lateinit var textView2 : EditText
    private lateinit var textView3 : EditText
    private lateinit var textView4 : EditText

    private lateinit var button0 : Button
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button
    private lateinit var buttonUndo : Button

    private lateinit var code : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.verification_code_manual)

        nextButton = findViewById(R.id.button)
        nextButton.isEnabled = false

        textView1 = findViewById(R.id.editTextNumber)
        textView2 = findViewById(R.id.editTextNumber2)
        textView3 = findViewById(R.id.editTextNumber3)
        textView4 = findViewById(R.id.editTextNumber4)

        button0 = findViewById(R.id.button_no_0)
        button1 = findViewById(R.id.button_no_1)
        button2 = findViewById(R.id.button_no_2)
        button3 = findViewById(R.id.button_no_3)
        button4 = findViewById(R.id.button_no_4)
        button5 = findViewById(R.id.button_no_5)
        button6 = findViewById(R.id.button_no_6)
        button7 = findViewById(R.id.button_no_7)
        button8 = findViewById(R.id.button_no_8)
        button9 = findViewById(R.id.button_no_9)
        buttonUndo = findViewById(R.id.button_undo)
    }

    fun setTextForEditable(text: String) {
        when {
            textView1.text.isEmpty() -> textView1.setText(text)
            textView2.text.isEmpty() -> textView2.setText(text)
            textView3.text.isEmpty() -> textView3.setText(text)
            textView4.text.isEmpty() -> {
                textView4.setText(text)
                code = textView1.text.toString() + textView2.text.toString() + textView3.text.toString() + textView4.text.toString()
                nextButton.isEnabled = true
            }
        }
    }

    fun undo(view: View) {
        when {
            textView4.text.isNotEmpty() -> textView4.setText("")
            textView3.text.isNotEmpty() -> textView3.setText("")
            textView2.text.isNotEmpty() -> textView2.setText("")
            textView1.text.isNotEmpty() -> textView1.setText("")
        }
        nextButton.isEnabled = false
    }

    fun writeNumber(view : View){
        when (view.id){
            button0.id -> setTextForEditable("0")
            button1.id -> setTextForEditable("1")
            button2.id -> setTextForEditable("2")
            button3.id -> setTextForEditable("3")
            button4.id -> setTextForEditable("4")
            button5.id -> setTextForEditable("5")
            button6.id -> setTextForEditable("6")
            button7.id -> setTextForEditable("7")
            button8.id -> setTextForEditable("8")
            button9.id -> setTextForEditable("9")
        }
    }

    fun finished(view : View){
        intent.putExtra("code", code)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
    override fun onBackPressed() {
        finish()
    }
}