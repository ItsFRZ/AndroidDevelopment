package com.itsfrz.fragmentmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity2 : AppCompatActivity() {

    var fragmentManager : FragmentManager? = null
    var fragment : Fragment? = null

    var stackTransactionEntryCounter = 0
    var STACKTRANSACTIONENTRYOPERATION = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       fragmentManager = supportFragmentManager
       addDefaultFragment()

    }

    private fun addDefaultFragment() {
        val fragmentTransaction : FragmentTransaction = fragmentManager!!.beginTransaction()
        val fragmentOne : FragmentOne = FragmentOne()
        fragmentTransaction.add(R.id.myStackFragmentContainer,fragmentOne)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        STACKTRANSACTIONENTRYOPERATION= "ADD"
        stackTransactionEntryCounter++
        Log.d(STACKTRANSACTIONENTRYOPERATION, "STACKTRANSACTIONENTRYOPERATION: $STACKTRANSACTIONENTRYOPERATION $stackTransactionEntryCounter")
    }


    fun replaceFragment(view: View) {
        val fragmentTransaction : FragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.myStackFragmentContainer,FragmentTwo())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        stackTransactionEntryCounter++
        var STACKTRANSACTIONENTRYOPERATION = "REPLACE"
        Log.d(STACKTRANSACTIONENTRYOPERATION, "STACKTRANSACTIONENTRYOPERATION: $STACKTRANSACTIONENTRYOPERATION $stackTransactionEntryCounter")
    }

    override fun onBackPressed() {
        stackTransactionEntryCounter++
        var STACKTRANSACTIONENTRYOPERATION = "REMOVE"
        Log.d(STACKTRANSACTIONENTRYOPERATION, "STACKTRANSACTIONENTRYOPERATION: $STACKTRANSACTIONENTRYOPERATION $stackTransactionEntryCounter")
        super.onBackPressed()
    }
}