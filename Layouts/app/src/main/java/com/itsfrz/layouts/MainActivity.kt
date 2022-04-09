package com.itsfrz.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var addButton : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.add);

        addButton?.setOnClickListener({

            val inputOne = findViewById<EditText>(R.id.inputOne);
            val inputTwo = findViewById<EditText>(R.id.inputTwo);
            val result = findViewById<TextView>(R.id.result);

            try{
                val no1 : Int = inputOne.text.toString().trim().toInt();
                val no2 : Int = inputTwo.text.toString().trim().toInt();
                result.text = "${no1+no2}"

            }catch (e : Exception){
                Toast.makeText(this@MainActivity, "Please enter integers only", Toast.LENGTH_SHORT).show()
                result.text = "Please enter integers only in input";
            }

        })


    }


}