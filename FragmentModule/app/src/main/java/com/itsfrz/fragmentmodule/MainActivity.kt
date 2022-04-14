package com.itsfrz.fragmentmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initAllMethods()

    }

    private fun initAllMethods() {
        addFragmentOne()
    }


    fun addFragmentOne(){

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        val fragmentOne : FragmentOne = FragmentOne()
        fragmentTransaction.add(R.id.fragmentContainer,fragmentOne)
        fragmentTransaction.commit()


    }
}