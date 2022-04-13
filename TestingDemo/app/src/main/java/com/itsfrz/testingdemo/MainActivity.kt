package com.itsfrz.testingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var username : EditText? = null
    var password : EditText? = null
    var confirmPassword : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView();
    }

    private fun initView() {
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        confirmPassword = findViewById(R.id.confirmPassword)
    }


    /*
    * Password should be greater then 8 characters
    * Both password should be same
    * Username should be greater then 4 characters
    * Username should not contain digits or numerical value
    *  */
    fun validateCredentials(
        username : String,
        password : String,
        confirmPassword : String
    ) : Boolean{

        if(username.isEmpty() || password.isEmpty())
            return false

        if(password != confirmPassword)
            return false

        if(password.length < 8 || username.length < 4)
            return false

        if(username.count { it.isDigit() } > 0)
            return false


        return true;
    }

    fun Login(view: View) {
        val username = username?.text.toString()
        val password = password?.text.toString()
        val confirmPassword = confirmPassword?.text.toString()

        if (validateCredentials(username,password,confirmPassword))
            Toast.makeText(this, "Valid Credentials", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
    }
}