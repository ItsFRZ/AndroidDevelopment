package com.itsfrz.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    val ACTIVITY_TAG = "${javaClass.simpleName}"
    val COMMON_TAG = "COMBINEDLIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(COMMON_TAG, ACTIVITY_TAG+":- onCreate ")
//        addFragment()


        val addFragment = findViewById<Button>(R.id.button);
        addFragment.setOnClickListener {
            addFragment()
        }
    }

    fun addFragment(){
        var fragment : Fragment? = null
        val fragmentManager : FragmentManager = supportFragmentManager
        when(fragmentManager.backStackEntryCount){
            0 -> {
                fragment = FragmentOne()
            }
            1 -> {
                fragment = FragmentTwo()
            }
            2 -> {
                fragment = FragmentThree()
            }
            3 -> {
                fragment = FragmentFour()
            }
            else -> {
                fragment = FragmentOne()
            }
        }

        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentOnePlaceholder,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }


    override fun onStart() {
        super.onStart()
        Log.d(COMMON_TAG, ACTIVITY_TAG+":- onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(COMMON_TAG, ACTIVITY_TAG+":- onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(COMMON_TAG, ACTIVITY_TAG+":- onPause ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(COMMON_TAG, ACTIVITY_TAG+":- onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(COMMON_TAG, ACTIVITY_TAG+":- onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(COMMON_TAG, ACTIVITY_TAG+":- onDestroy")
    }

}