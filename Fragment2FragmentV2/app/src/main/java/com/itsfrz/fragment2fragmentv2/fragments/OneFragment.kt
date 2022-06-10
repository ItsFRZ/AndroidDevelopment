package com.itsfrz.fragment2fragmentv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.itsfrz.fragment2fragmentv2.Communicator
import com.itsfrz.fragment2fragmentv2.R


class OneFragment : Fragment() {
    private lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_one, container, false)
        val sendButton = view.findViewById<Button>(R.id.sendButton);
        val inputMessage : EditText = view.findViewById(R.id.inputMessage)

        communicator = activity as Communicator
        sendButton.setOnClickListener {
            communicator.passData(inputMessage.text.toString())
        }

        return view
    }

}