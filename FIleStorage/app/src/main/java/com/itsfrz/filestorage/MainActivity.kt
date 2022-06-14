package com.itsfrz.filestorage

import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.*

class MainActivity : AppCompatActivity() {

    private val FILE_NAME = "Sample.txt"
    private val FILE_PATH = "${Environment.getExternalStorageDirectory().path}"
    private lateinit var inputText : EditText
    private lateinit var outputText : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        inputText = findViewById(R.id.inputText)
        outputText = findViewById(R.id.outputText)
    }

    fun saveData(view: View) {
        if (inputText.text.toString().length > 0){
            writeToFile(FILE_NAME,inputText.text.toString());
        }
    }

    private fun writeToFile(fileName: String, data: String) {
        val dataDir = ContextCompat.getDataDir(this)
        val myFile = File(dataDir,fileName)
        myFile.writeText(data)
    }


    fun readData(view: View) {
      readFile(FILE_NAME)

    }

    private fun readFile(fileName: String) {
        val dataDir = ContextCompat.getDataDir(this)
        val myFile = File(dataDir,fileName)
        outputText.text = myFile.readText()
    }


}