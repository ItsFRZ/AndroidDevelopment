package com.itsfrz.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsfrz.fragmentcommunication.databinding.FragmentOneBinding

class FragmentOne : Fragment() {


    private var _binding : FragmentOneBinding? = null
    private val binding
        get() = _binding!!




    private lateinit var actionListener: FragementActionListener;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentOneBinding.inflate(inflater, container, false)


        actionListener = activity as FragementActionListener

        binding.sendButton.setOnClickListener {
            val bundle : Bundle = Bundle()
            bundle.putString("message",binding.inputMessage.text.toString().trim())
            actionListener.sendAction(bundle)
        }


        return binding.root;

    }

    fun setFragmentActionListenerInterface(actionListener: FragementActionListener){
        this.actionListener = actionListener;
    }


}