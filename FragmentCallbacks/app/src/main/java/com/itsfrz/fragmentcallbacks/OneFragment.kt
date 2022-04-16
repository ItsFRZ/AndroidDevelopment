package com.itsfrz.fragmentcallbacks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class OneFragment : Fragment() {

    private lateinit var callBackInterface : CallBackInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View  = inflater.inflate(R.layout.fragment_one, container, false)
        val launchButton : Button = view.findViewById(R.id.launchAnotherFragment);

        launchButton.setOnClickListener {
            callBackInterface?.onCallBackMethod() ?: showNUllToast()
        }
        return view
    }

    fun setCallBackInterface(callBackInterface: CallBackInterface){
        this.callBackInterface = callBackInterface
    }

    private fun showNUllToast() {
        Toast.makeText(requireContext(), "Callback Interface holding NULL", Toast.LENGTH_SHORT).show()
    }

}