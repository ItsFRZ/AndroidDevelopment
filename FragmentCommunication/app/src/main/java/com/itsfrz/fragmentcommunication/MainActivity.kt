package com.itsfrz.fragmentcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() , FragementActionListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentOne = FragmentOne()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,fragmentOne).commit()

    }

    override fun sendAction(bundle: Bundle) {



    }
}