package com.itsfrz.fragmentrevision10

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
class OneFragment : Fragment() {

    private val TAG : String = "fragmentone"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, tag+" onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, tag+" onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView : View = inflater.inflate(R.layout.fragment_one, container, false)
        Log.d(TAG, "${tag} onCreateView")
        return fragmentView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "$tag onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$tag onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$tag onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "${tag} onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "${tag} onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "${tag} onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$tag onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "${tag} onDetach")
    }

}