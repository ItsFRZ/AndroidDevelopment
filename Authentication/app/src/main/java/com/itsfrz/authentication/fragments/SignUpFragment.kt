package com.itsfrz.authentication.fragments

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.itsfrz.authentication.AuthenticationCommunicator
import com.itsfrz.authentication.Database.LocalDatabaseHelper
import com.itsfrz.authentication.Database.UserTable
import com.itsfrz.authentication.Model.User
import com.itsfrz.authentication.R


class SignUpFragment : Fragment() {

    private lateinit var communicator: AuthenticationCommunicator


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        // View Initilization
        val usernameInput = view.findViewById<EditText>(R.id.registerUsernameInput)
        val passwordInput = view.findViewById<EditText>(R.id.registerPasswordInput)
        val passwordReInput = view.findViewById<EditText>(R.id.registerAgainPasswordInput)
        val registerButton = view.findViewById<Button>(R.id.registerButton)


        // Communicator Interface set
        communicator = activity as AuthenticationCommunicator
        registerButton.setOnClickListener {
            if(checkValidate(usernameInput,passwordInput,passwordReInput) && checkCrossPassword(passwordInput,passwordReInput))
            {
                saveToDatabase(usernameInput.text.toString(),passwordInput.text.toString())
                communicator.routeToLogin(usernameInput.text.toString())
            }
        }



        return view
    }

    private fun saveToDatabase(username: String, password: String) {
        val userDatabase : SQLiteDatabase = LocalDatabaseHelper(this.requireContext()).writableDatabase
        val userTable = UserTable.insertUser(User(username,password),userDatabase)
        Toast.makeText(this.requireContext(), "$username is registered in database", Toast.LENGTH_SHORT).show()
    }

    private fun checkCrossPassword(passwordInput: EditText, passwordReInput: EditText): Boolean {
        if (passwordInput.text.toString().equals(passwordReInput.text.toString()))
            return true
        passwordInput.setError("Password field should be same Re-Password")
        passwordReInput.setError("Re-Password field should be same as Password")
        return false
    }

    private fun checkValidate(usernameInput: EditText, passwordInput: EditText, passwordReInput: EditText): Boolean {
        if (usernameInput.text.toString().length <= 0) {
            usernameInput.setError("Username field should not be empty")
            return false
        }
        if (passwordInput.text.toString().length <= 0) {
            passwordInput.setError("Password field should not be empty")
            return false
        }
        if (passwordReInput.text.toString().length <= 0) {
            passwordReInput.setError("Re-Password field should not be empty")
            return false
        }
        return true
    }


}