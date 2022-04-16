package com.itsfrz.syntheticviewbinding

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_synthetic.view.*


class SyntheticFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_synthetic, container, false)

        view.lightOff.setOnClickListener {
            view.fragmentLayout.setBackgroundColor(Color.BLACK)
        }

        return view;
    }



}