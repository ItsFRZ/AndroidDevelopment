package com.itsfrz.basiccalci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap


class MainActivity : AppCompatActivity() {


    private var input : TextView? = null;
    private var output : TextView? = null;
    private var rawData : TextView? = null;


    private val history : Stack<String> = Stack();

    private var oldData : String = ""
    private var operand : String = "+"
    private var isNewOp : Boolean = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initAllViews()
    }

    private fun initAllViews() {
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        rawData = findViewById(R.id.rawData);
    }

    fun numberEvent(view: View) {
        if(isNewOp)
            input?.text = ""
        isNewOp = false
        var data = input?.text.toString().trim()

        when(view.id){
            R.id.zero -> {
                data += "0"
            }
            R.id.one -> {
                data += "1"
            }
            R.id.two -> {
                data += "2"
            }
            R.id.three -> {
                data += "3"
            }
            R.id.four -> {
                data += "4"
            }
            R.id.five -> {
                data += "5"
            }
            R.id.six -> {
                data += "6"
            }
            R.id.seven -> {
                data += "7"
            }
            R.id.eight -> {
                data += "8"
            }
            R.id.nine -> {
                data += "9"
            }
            R.id.left_paranthesis -> {
                data += "("
            }
            R.id.right_paranthesis -> {
                data += ")"
            }
            R.id.dot -> {
                data += "."
            }

        }
        input?.text = data ?: "";


    }

    fun operatorEvent(view: View) {
        isNewOp = true;
        oldData = input?.text.toString() ?: ""

        when(view.id){
            R.id.plus -> operand = "+"
            R.id.multiply -> operand = "*"
            R.id.divide -> operand = "/"
            R.id.modulo -> operand = "%"
            R.id.minus -> operand = "-"

        }
    }

    fun equal(view: View) {
        val newNumber : String = input?.text.toString() ?: ""
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
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
            clearData(view)
        }

        output?.text = result.toString()
        input?.text = result.toString()

        setRawData(oldData,operand,newNumber)

        val historyOfEntry = oldData+operand+newNumber
        oldData = result.toString()

        history.push(historyOfEntry+"="+oldData)

    }

    private fun setRawData(oldData: String, operand: String, newNumber: String) {
        val rawString = oldData+operand+newNumber

        rawData?.text = rawString
    }

    fun clearData(view: View) {
        input?.text = ""
        output?.text = ""
        rawData?.text = ""
        oldData = ""
    }

    fun history(view: View) {
      if(history.size >= 1){
          val(entry,result) = history.pop().split("=");
          output?.text = result
          rawData?.text = entry
      }
    }


}