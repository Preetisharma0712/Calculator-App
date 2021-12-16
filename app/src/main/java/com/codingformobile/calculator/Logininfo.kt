package com.example.calculator

class Logininfo {
    companion object {

        var fullname: String = "preeti"
        var phone: String = "72278****"
        var email: String = "preeti0712@gmail.com"
        var city: String = "Assam"
        var password: String = "preeti0712"
        var confirm_pass: String = "preeti0712"
        var Login: Boolean = false
        fun Login(email:String, pwd:String):Boolean{
            Login= email==email && password==pwd
            return Login
        }
        fun logout() {
            Login = false
        }
    }

}

