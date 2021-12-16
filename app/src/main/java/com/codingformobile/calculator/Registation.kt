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
import com.example.calculator.Logininfo.Companion.city
import com.example.calculator.Logininfo.Companion.confirm_pass
import com.example.calculator.Logininfo.Companion.email
import com.example.calculator.Logininfo.Companion.fullname
import com.example.calculator.Logininfo.Companion.password
import com.example.calculator.Logininfo.Companion.phone
import com.google.android.material.textfield.TextInputEditText

class Registation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registation)
        setStatusBarTransparent()
        supportActionBar?.hide()


        val SignUp=findViewById<Button>(R.id.registerSignUP)
        val sign=findViewById<Button>(R.id.signupbtn)
        val fullname_signup=findViewById<TextInputEditText>(R.id.fullname)
        val phone_signup=findViewById<TextInputEditText>(R.id.phoneNumber)
        val email_signup=findViewById<TextInputEditText>(R.id.Email)
        val city_signup=findViewById<TextInputEditText>(R.id.city)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val password_signup=findViewById<TextInputEditText>(R.id.passwordLogin)
        val confirm_pass_signup=findViewById<TextInputEditText>(R.id.ConfirmpasswordLogin)

//        sign.setOnClickListener({
//            Intent(this,MainActivity::class.java).apply {
//                startActivity(this)
//            }
//        })

        textView5.setOnClickListener(View.OnClickListener {
            val intent= Intent(this@Registation,MainActivity::class.java)
            startActivity(intent)
        })

        SignUp.setOnClickListener({

            fullname=fullname_signup.text.toString()
            phone=phone_signup.text.toString()
            email=email_signup.text.toString()
            city=city_signup.text.toString()
            password=password_signup.text.toString()
            confirm_pass=confirm_pass_signup.text.toString()

            if(password== confirm_pass)
            {
                Intent(this,MainActivity::class.java).apply {
                    startActivity(this)
                }
            }
            else{

                Toast.makeText(applicationContext,"Password and Confirm Password does not match", Toast.LENGTH_LONG).show()
            }

        })




    }

    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT in 19..20) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
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
