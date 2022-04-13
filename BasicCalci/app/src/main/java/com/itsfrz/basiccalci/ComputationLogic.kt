package com.itsfrz.basiccalci

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.util.*

class ComputationLogic {

    val EXCEPTION_TAG = "EXCEPTION"




    /*

        When parameters are empty
        When addition check return value
        When subtraction check return value
        When division check return value
        When multiplication check return value

     */

    public fun equal(newNumber : String,operand: String,oldData: String) : Double {

        if(newNumber.isEmpty() || oldData.isEmpty())
            return 0.0

        var result : Double = 0.0
        try{
            when(operand){
                "+" -> {
                    result = oldData.toDouble() + newNumber.toDouble()
                }
                "-" -> {
                    result = oldData.toDouble() - newNumber.toDouble()
                }
                "/" -> {
                    result = oldData.toDouble() / newNumber.toDouble()
                }
                "*" -> {
                    result = oldData.toDouble() * newNumber.toDouble()
                }
                "%" -> {
                    result = oldData.toDouble() % newNumber.toDouble()
                }
            }

        }catch (e : Exception){
             Log.d(EXCEPTION_TAG, ""+e)
        }

        return result;
    }



}