package com.itsfrz.fragment2fragmentv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.itsfrz.fragment2fragmentv2.fragments.OneFragment
import com.itsfrz.fragment2fragmentv2.fragments.TwoFragment

class MainActivity : AppCompatActivity(),Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initFragment();

    }

    private fun initFragment() {
        val fragmentOne : Fragment = OneFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer,fragmentOne)
        fragmentTransaction.commit()
    }

    override fun passData(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message",editTextInput)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentTwo : TwoFragment = TwoFragment();
        fragmentTwo.arguments = bundle

        fragmentTransaction.replace(R.id.fragmentContainer,fragmentTwo)
        fragmentTransaction.commit()
    }
}