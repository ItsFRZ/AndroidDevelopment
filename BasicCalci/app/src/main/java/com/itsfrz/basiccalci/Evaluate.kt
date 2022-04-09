package com.itsfrz.basiccalci

import org.mariuszgromada.math.mxparser.Expression

class Evaluate {

    fun eval(expression : String) : Double{

        val e = Expression(expression)
        return e.calculate();
    }



}