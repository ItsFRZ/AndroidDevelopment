package com.itsfrz.syntheticviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myWorld.text = "Hello Every One to My World"

        fragmentButton.setOnClickListener {
            addFragment()

        }

    }



    fun addFragment(){

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer,SyntheticFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onResume() {
        super.onResume()


    }
}



