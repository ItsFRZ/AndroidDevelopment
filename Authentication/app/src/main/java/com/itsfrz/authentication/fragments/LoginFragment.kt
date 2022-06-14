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
import com.itsfrz.authentication.database.LocalDatabaseHelper
import com.itsfrz.authentication.database.PreferenceRespository
import com.itsfrz.authentication.database.UserTable
import com.itsfrz.authentication.model.User
import com.itsfrz.authentication.R
import java.util.*


class LoginFragment : Fragment() {

    private lateinit var communicator: AuthenticationCommunicator
    private val preferenceRespository by lazy {
        PreferenceRespository(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val usernameInput : EditText = view.findViewById<EditText>(R.id.loginUsernameInput)
        val passwordInput = view.findViewById<EditText>(R.id.loginPasswordInput)
        val loginButton = view.findViewById<Button>(R.id.loginButton)
        val signUpButton = view.findViewById<Button>(R.id.signUpButon)
        communicator = activity as AuthenticationCommunicator

        viaSignUp(usernameInput)
        loginButton.setOnClickListener {
            if(validateInputs(usernameInput,passwordInput))
            {
                val user : User = getUserInfoFromDatabase(usernameInput.text.toString(),passwordInput.text.toString())
                if (user.username.equals(usernameInput.text.toString())
                    &&
                    user.password.equals(passwordInput.text.toString())){
                    persistMyPreferences(usernameInput.text.toString());
                    communicator.routerFromLoginToContactPage(usernameInput.text.toString())
                }else{
                    Toast.makeText(this.context, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        signUpButton.setOnClickListener {
            communicator.routeToSignUp()
        }

        return view
    }

    private fun persistMyPreferences(username: String) {
        preferenceRespository.setCurrentUser(username)
        preferenceRespository.setLoggedIn(true)
        preferenceRespository.setLoggedInDate(Calendar.getInstance().time.toString())
    }

    private fun getUserInfoFromDatabase(username: String, password: String): User {
        val databaseHelper : SQLiteDatabase = LocalDatabaseHelper(this.requireContext()).writableDatabase
        return UserTable.getUser(username,password,databaseHelper)
    }

    private fun viaSignUp(usernameInput : EditText) {
        val data : String? = arguments?.getString("username").toString() ?: ""
        usernameInput.setText(data ?: "")
    }


    private fun validateInputs(usernameInput: EditText?, passwordInput: EditText?): Boolean {
        if (usernameInput?.text.toString().length <= 0)
        {
            usernameInput?.setError("Username field should not be empty")
            return false
        }

        if (passwordInput?.text.toString().length <= 0)
        {
            passwordInput?.setError("Passowrd field should not be empty")
            return false
        }
        return true
    }
}