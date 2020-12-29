package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.uid.project.sportify.models.Registry
import java.util.*
import kotlin.concurrent.schedule

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.isEnabled = false

        val emailError = findViewById<TextView>(R.id.invalidEmailTextView)
        emailError.visibility = View.GONE

        val loginError = findViewById<TextView>(R.id.invalidCredentialsLabel)
        loginError.visibility = View.GONE

        var passwordText = findViewById<EditText>(R.id.loginPasswordEditText)

        var emailText = findViewById<EditText>(R.id.loginEmailEditText)
        emailText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                if(!isEmailValid(emailText.text.toString())){
                    emailError.visibility = View.VISIBLE
                }else{
                    emailError.visibility = View.GONE
                }
            }
        }

        val loginProgressBar = findViewById<ProgressBar>(R.id.loginProgressBar)
        loginProgressBar.visibility = View.GONE

        emailText.doOnTextChanged { text, start, before, count ->
            loginButton.isEnabled = passwordText.text.isNotEmpty() && text!!.isNotEmpty()
        }

        passwordText.doOnTextChanged { text, start, before, count ->
            loginButton.isEnabled = emailText.text.isNotEmpty() && text!!.isNotEmpty()
        }

        loginButton.setOnClickListener {
            loginError.visibility = View.GONE
            loginProgressBar.visibility = View.VISIBLE
            Timer("LoginProgress", false).schedule(2000) {
                Handler(mainLooper).post{
                    loginProgressBar.visibility = View.GONE
                    if (emailText.text.toString() == Registry.user1Manager.email && passwordText.text.toString() == Registry.user1Manager.password){
                        loginError.visibility = View.GONE
                        val intent = Intent(this@LoginActivity, NewsFeedActivity::class.java)
                        startActivity(intent)
                    }else{
                        loginError.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}