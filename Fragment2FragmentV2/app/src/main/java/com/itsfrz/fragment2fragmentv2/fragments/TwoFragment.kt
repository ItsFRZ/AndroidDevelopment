package com.itsfrz.fragment2fragmentv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.itsfrz.fragment2fragmentv2.R
import org.w3c.dom.Text

class TwoFragment : Fragment() {


    var displayMessage : String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_two, container, false)
        val outputMessage = view.findViewById<TextView>(R.id.outputMessage)
        displayMessage = arguments?.getString("message")
        outputMessage.setText(displayMessage)


        return view;
    }

}