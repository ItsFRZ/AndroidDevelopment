package com.itsfrz.fragmentmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity3 : AppCompatActivity() {


    private var fragment : Fragment? = null
    private var fragmentManager : FragmentManager? = null
    private var fragmentTurns : Int  = 0

    private val TRANSACTION_STACK = "Entry_Stack"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        fragmentManager = supportFragmentManager

    }

    fun getFragment() : Fragment?{
        when(fragmentTurns){
            0 -> {
                return FragmentOne()
            }
            1 -> {
                return FragmentTwo()
            }
            2 -> {
                return FragmentThree()
            }
        }
        return null
    }

    fun addFragments(view: View) {
        fragmentTurns = fragmentTurns%3;
        fragment = getFragment()

        var fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.add(R.id.fragment_placeholder,fragment ?: FragmentOne())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        fragmentTurns++
        Log.d(TRANSACTION_STACK, "addFragments: "+fragmentManager!!.backStackEntryCount)
    }

    fun deleteFragment(view: View) {
        fragmentManager!!.popBackStack(0,0)
        fragmentTurns--
        Log.d(TRANSACTION_STACK, "deleteFragment: "+fragmentManager!!.backStackEntryCount)

    }
    fun removeFragment(view: View) {

        fragment = fragmentManager!!.findFragmentById(R.id.fragment_placeholder)
        var fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.remove(fragment ?: FragmentOne())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

        Log.d(TRANSACTION_STACK, "removeFragment: "+fragmentManager!!.backStackEntryCount)
        fragmentTurns--
    }


}