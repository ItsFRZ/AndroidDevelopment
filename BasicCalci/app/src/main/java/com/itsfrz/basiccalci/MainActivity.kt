package com.itsfrz.basiccalci

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    private var copiedHistory = ""

    private lateinit var computationHistory : ComputationHistory;
    private lateinit var computationLogic : ComputationLogic;


    private val HISTORY_DATA = "History_Data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        initAllViews()
        initAllReferences()
        setLongPressCopy()
    }

    private fun initAllReferences() {
        computationHistory = ComputationHistory()
        computationLogic = ComputationLogic()
    }

    private fun setLongPressCopy() {
        rawData!!.setOnLongClickListener(View.OnLongClickListener {

                input!!.text = output!!.text
                rawData!!.text = ""
                output!!.text = ""
                Log.d(HISTORY_DATA, "setLongPressCopy: "+input.toString()+" "+output.toString())
                changeViewColor(rawData,true)

            true
        })
    }


    private fun changeViewColor(rawData: TextView?,colorIt : Boolean) {
        if(colorIt){
            input!!.setBackgroundColor(resources.getColor(R.color.light_green))
        }else{
            input!!.setBackgroundColor(resources.getColor(R.color.transparent))
        }
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
        val result = computationLogic.equal(newNumber, operand, oldData)
        setResult(result)
        setRawData(newNumber)
        changeViewColor(input,false)
        computationHistory.saveHistory("${(oldData+operand+newNumber)}=$result",history)

    }

    private fun setRawData(newData : String) {
       val rData : String= oldData+operand+newData
       rawData!!.text = rData
    }

    private fun setResult(value : Double){
        output?.text = value.toString()
    }

    fun clearData(view: View){
        clearAllData()
    }

    private fun clearAllData() {
        input!!.text = ""
        rawData!!.text = ""
        output!!.text = ""

    }

    fun showHistory(view: View) {
        val previousComputation : String = computationHistory.showHistory(history)
        setHistoryData(previousComputation)
    }

    private fun setHistoryData(previousComputation: String) {
       if (!previousComputation.isEmpty()){
           val(data,result) = previousComputation.split("=")
           rawData!!.text = data
           output!!.text = result
           input!!.text = ""
       }
    }


}