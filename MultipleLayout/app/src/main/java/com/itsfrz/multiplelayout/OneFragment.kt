package com.itsfrz.multiplelayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsfrz.multiplelayout.databinding.ActivityMainBinding
import com.itsfrz.multiplelayout.databinding.FragmentOneBinding


class OneFragment : Fragment() {


    private var _binding : FragmentOneBinding? = null
    private val binding
        get() = _binding!!


    private lateinit var fragmentActionListener: FragmentActionListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentOneBinding.inflate(inflater,container,false)

        binding.buttonSend.setOnClickListener {

            val message : String = binding.inputField.text.toString()
            val bundle = Bundle()
            bundle.putString("message",message)
            fragmentActionListener.sendAction(bundle)
        }


        return binding.root
    }

    public fun setActionListener(fragmentActionListener: FragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener
    }

}