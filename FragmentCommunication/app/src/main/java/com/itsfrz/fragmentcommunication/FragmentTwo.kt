package com.itsfrz.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsfrz.fragmentcommunication.databinding.FragmentOneBinding
import com.itsfrz.fragmentcommunication.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {


    private var _binding : FragmentTwoBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTwoBinding.inflate(inflater, container, false)

        val bundle : Bundle? = arguments
        val message = bundle?.get("message") ?: ""
        binding.outputMessage.text = "Message :-\n${message.toString()}"



        return binding.root
    }

}