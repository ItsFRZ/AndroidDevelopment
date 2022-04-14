package com.itsfrz.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity2 : AppCompatActivity() {

    var fragmentManager : FragmentManager? = null
    val demoBackFragment = DemoBackFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        fragmentManager = supportFragmentManager

    }

    fun Add(view: View) {
        val fragmentTransaction = fragmentManager!!.beginTransaction();
        fragmentTransaction.add(R.id.demoFragmentPlaceholder,demoBackFragment)
        fragmentTransaction.commit()
    }
    fun Remove(view: View) {
        onBackPressed()
    }

    override fun onBackPressed() {
        val myFragmetInfo : Fragment? = fragmentManager!!.findFragmentById(R.id.demoFragmentPlaceholder)
        if (myFragmetInfo != null){
            val fragmentTransaction = fragmentManager!!.beginTransaction();
            fragmentTransaction.remove(demoBackFragment)
            fragmentTransaction.commit()
        }else{
            super.onBackPressed()
        }



    }

}