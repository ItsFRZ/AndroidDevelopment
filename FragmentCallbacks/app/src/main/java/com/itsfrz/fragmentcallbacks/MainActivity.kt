package com.itsfrz.fragmentcallbacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() , CallBackInterface{
    var fragmentManager : FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
    }

    override fun onCallBackMethod() {
        Toast.makeText(this@MainActivity, "CallBack Launch", Toast.LENGTH_SHORT).show()
        val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        val fragmentTwo : TwoFragment = TwoFragment()
        fragmentTransaction.add(R.id.fragmentPlaceholder,fragmentTwo)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        fragmentManager!!.popBackStack()
    }

    fun addFragment(view: View) {
        Toast.makeText(this@MainActivity, "CallBack Launch", Toast.LENGTH_SHORT).show()
        val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        val fragmentOne : OneFragment = OneFragment()
        fragmentOne.setCallBackInterface(this)
        fragmentTransaction.add(R.id.fragmentPlaceholder,fragmentOne)
        fragmentTransaction.commit()
    }

}