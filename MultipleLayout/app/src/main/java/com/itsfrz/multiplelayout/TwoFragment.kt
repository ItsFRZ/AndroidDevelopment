package com.itsfrz.multiplelayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsfrz.multiplelayout.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    private var _binding : FragmentTwoBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTwoBinding.inflate(inflater,container,false)


        val bundle : Bundle? = arguments
        binding.outputField.text = bundle?.getString("message") ?: ""

        return binding.root
    }

}