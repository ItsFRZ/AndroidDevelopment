package com.itsfrz.fragmentcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() , FragementActionListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addInitFragment()

    }

    private fun addInitFragment() {

        val fragmentOne = FragmentOne()
        fragmentOne.setFragmentActionListenerInterface(this)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer,fragmentOne)
            .commit()
    }

    override fun sendAction(bundle: Bundle) {

        val fragmentTwo = FragmentTwo()
        fragmentTwo.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer,fragmentTwo)
            .addToBackStack(null)
            .commit()
    }
}