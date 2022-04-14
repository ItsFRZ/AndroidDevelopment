package com.itsfrz.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentTwo : Fragment() {

    val FRAGMENT_TAG = javaClass.simpleName
    val COMMON_TAG = "COMBINEDLIFECYCLE"
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onAttach ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onCreate ")

    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onCreateView ")

        return inflater.inflate(R.layout.fragment_two,container,false);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onActivityCreated ")

    }

    override fun onStart() {
        super.onStart()
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onStart ")

    }

    override fun onResume() {
        super.onResume()
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onResume ")

    }

    override fun onPause() {
        super.onPause()
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onPause ")

    }

    override fun onStop() {
        super.onStop()
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onStop ")

    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onDestroyView ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onDestroy ")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d(COMMON_TAG, FRAGMENT_TAG+" :- onDetach ")

    }

}