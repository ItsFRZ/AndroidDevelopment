package com.itsfrz.fragmentrevision10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {



    var fragmentManager : FragmentManager? = null
    val COUNT : String = "FragmentCount"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        addFragment();

        fragmentManager = supportFragmentManager
        val addFragmentButton : Button = findViewById(R.id.addFragmentButton);
        addFragmentButton.setOnClickListener {
            addFragment()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(COUNT, "onBackPressed: ${fragmentManager!!.backStackEntryCount}")
    }

    private fun addFragment() {
        lateinit var fragment : Fragment
        when(fragmentManager!!.backStackEntryCount)
        {
            0 -> {
             fragment = OneFragment()
            }
            1 -> {
                fragment = TwoFragment()
            }
            2 -> {
                fragment = ThreeFragment()
            }
            else -> {
                fragment = OneFragment()
            }
        }
        Log.d(COUNT, "addFragment: ${fragmentManager!!.backStackEntryCount}")
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainerOne,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}