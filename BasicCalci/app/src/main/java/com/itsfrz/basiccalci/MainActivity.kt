package com.itsfrz.basiccalci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {


    private var input : TextView? = null;
    private var output : TextView? = null;
    private var rawData : TextView? = null;

    private var history : Stack<String> = Stack();


    private var data : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        rawData = findViewById(R.id.rawData);

    }

    fun setData(input : String){
        data += input
    }

    fun setView(){
        output?.text = data;
    }

    fun setView(data : String){
        this.data = data
        setView()
    }

    fun One(view: View) {
         setData("1")
         setView()
         clearRawData()
    }
    fun Two(view: View) {
        setData("2")
        setView()
        clearRawData()
    }
    fun Three(view: View) {
        setData("3")
        setView()
        clearRawData()
    }
    fun Four(view: View) {
        setData("4")
        setView()
        clearRawData()
    }
    fun Five(view: View) {
        setData("5")
        setView()
        clearRawData()
    }
    fun Six(view: View) {
        setData("6")
        setView()
        clearRawData()
    }
    fun Seven(view: View) {
        setData("7")
        setView()
        clearRawData()
    }
    fun Eight(view: View) {
        setData("8")
        setView()
        clearRawData()
    }
    fun Nine(view: View) {
        setData("9")
        setView()
        clearRawData()
    }

    fun leftParanthesis(view: View) {
        setData("(")
        setView()
        clearRawData()
    }
    fun rightParanthesis(view: View) {
        setData(")")
        setView()
        clearRawData()
    }

    fun modulo(view: View) {
        setData("%")
        setView()
        clearRawData()
    }
    fun dot(view: View) {
        setData(".")
        setView()
        clearRawData()
    }
    fun clearData(view: View) {
        data = ""
        setData(data)
        setView()
        clearRawData()
    }

    fun backPress(view: View) {
        if(data.length >= 1){
            val myData = data.substring(0,data.length-1);
            clearData(view)
            setData(myData)
            setView()
            clearRawData()
        }
    }

    fun setRawData(myData  : String){
        rawData?.text = myData ?: ""
    }

    fun clearRawData(){
        rawData?.text = ""
    }

    fun equal(view: View) {
        try{
            val myData  = output?.text.toString() ?: ""
            val result : Double = process(myData)
            history.push(myData)
            clearData(view);
            setOutputResult(result);
            setRawData(myData)

        }catch (e : Exception){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setOutputResult(result: Double) {
        val temp = result.toString()
        setView(temp)
    }

    private fun process(expression: String): Double {
       return Evaluate().eval(expression);
    }

    fun multiply(view: View) {
        setData("*")
        setView()
        clearRawData()
    }
    fun divide(view: View) {
        setData("/")
        setView()
        clearRawData()
    }
    fun plus(view: View) {
        setData("+")
        setView()
        clearRawData()
    }
    fun minus(view: View) {
        setData("-")
        setView()
        clearRawData()
    }

    fun history(view: View) {
        if(!history.isEmpty())
        {
            val undo = history.pop();
            clearData(view)
            setData(undo)
            setView()
            clearRawData()
        }
    }

    fun zero(view: View) {
        setData("0")
        setView()
        clearRawData()
    }
}