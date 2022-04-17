package com.itsfrz.syntheticviewbinding

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsfrz.syntheticviewbinding.databinding.FragmentViewBindingBinding

class ViewBindingFragment : Fragment() {

    private var _binding : FragmentViewBindingBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding =  FragmentViewBindingBinding.inflate(inflater, container, false)
        binding.viewButton.setOnClickListener {
            binding.viewBindingLayout.setBackgroundColor(Color.MAGENTA)
        }


        return binding.root;
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}