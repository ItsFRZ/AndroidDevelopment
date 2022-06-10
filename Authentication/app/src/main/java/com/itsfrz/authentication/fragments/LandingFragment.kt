package com.itsfrz.authentication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.itsfrz.authentication.AuthenticationCommunicator
import com.itsfrz.authentication.Database.PreferenceRespository
import com.itsfrz.authentication.MainActivity
import com.itsfrz.authentication.R
import org.w3c.dom.Text

class LandingFragment : Fragment() {

    private lateinit var communicator: AuthenticationCommunicator
    private val preferenceRespository by lazy {
        PreferenceRespository(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_landing, container, false)
        val outputUsername : TextView = view.findViewById(R.id.username)
        val outputDate : TextView = view.findViewById(R.id.loggedInDate)
        val outputLoggedStatus : TextView = view.findViewById(R.id.loggedStatus)
        val logout : Button = view.findViewById(R.id.logout)

        communicator = activity as AuthenticationCommunicator
        populateUserDetails(outputUsername,outputDate,outputLoggedStatus)

        logoutUser(logout)
        return view
    }

    private fun logoutUser(logoutButton : View) {
        logoutButton.setOnClickListener {
            preferenceRespository.clearUser()
            routeToActivity();
        }
    }

    private fun routeToActivity() {
        val intent = Intent(requireContext(),MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }



    private fun populateUserDetails(outputUsername: TextView, outputDate: TextView, outputLoggedStatus: TextView) {
        outputUsername.setText("Username ${preferenceRespository.getCurrentUser()}")
        outputDate.setText("Logged In Date ${preferenceRespository.getLoggedInDate()}")
        outputLoggedStatus.setText("User Login Status is Active")
    }


}