package com.itsfrz.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentOne : Fragment() {


    private lateinit var actionListener: FragementActionListener;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View =  inflater.inflate(R.layout.fragment_one, container, false)

        view.sendButton

        return view;

    }

    fun setFragmentActionListenerInterface(actionListener: FragementActionListener){
        this.actionListener = actionListener;
    }


}