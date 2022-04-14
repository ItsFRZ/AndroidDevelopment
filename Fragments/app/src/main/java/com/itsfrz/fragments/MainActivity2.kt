package com.itsfrz.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        addFragment()
    }

    private fun addFragment(){
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        val sampleFragment : SampleFragment = SampleFragment()
        fragmentTransaction.add(R.id.fragmentContainer,sampleFragment)
        fragmentTransaction.commit()

    }
}