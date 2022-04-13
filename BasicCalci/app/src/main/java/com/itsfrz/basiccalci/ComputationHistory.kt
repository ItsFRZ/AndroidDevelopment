package com.itsfrz.basiccalci

import java.util.*

class ComputationHistory {

    public fun saveHistory(historyData : String,history : Stack<String>) : Boolean{

        if(historyData.isEmpty())
            return false
        if(historyData.count{
                it.isLetter()
            } > 0)
                return false

        history.push(historyData)
        return true
    }



    fun showHistory(history : Stack<String>) : String{
        if(history.isEmpty())
            return ""
        if(history.size > 0){
            return history.pop();
        }
        return ""
    }

}