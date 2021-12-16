package com.codingformobile.calculator

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.Logininfo.Companion.email
import com.example.calculator.Logininfo.Companion.password
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)
        setStatusBarTransparent()

        val login_button = findViewById<Button>(R.id.loginbutton)//problem
        val signup_button = findViewById<Button>(R.id.signupbtn)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val textView = findViewById<TextView>(R.id.textView)
        val email_login = findViewById<TextInputEditText>(R.id.mainLoginEmailId)
        val password_login = findViewById<TextInputEditText>(R.id.mainpasswordLogin)

        textView5.setOnClickListener(View.OnClickListener {
            val intent= Intent(this@MainActivity,Registation::class.java)
            startActivity(intent)
        })

        signup_button.setOnClickListener {
            Intent(this, Registation::class.java).apply {
                startActivity(this)
            }
        }
        textView.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
        }

        login_button.setOnClickListener {
            var email_input = email_login.text.toString()
            var password_input = password_login.text.toString()
            if (email_input == email && password_input ==password.toString()) {
                Intent(this, calculator::class.java).apply {
                    startActivity(this)
                }
            } else {
                Toast.makeText(applicationContext, "Enter valid email or password", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT in 19..20){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val winParameters = window.attributes
        if (on) {
            winParameters.flags = winParameters.flags or bits
        } else {
            winParameters.flags = winParameters.flags and bits.inv()
        }
        window.attributes = winParameters
    }

}