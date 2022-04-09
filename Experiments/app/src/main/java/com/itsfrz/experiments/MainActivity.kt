package com.itsfrz.experiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() , View.OnClickListener{


    var counterOutput : TextView? = null;
    var counter : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterOutput = findViewById<TextView>(R.id.textView)

        val buttonTwo = findViewById<Button>(R.id.button2);
        val buttonThree = findViewById<Button>(R.id.button3);



        buttonTwo.setOnClickListener(View.OnClickListener {
            counter += 2
            setText()
        })

        buttonThree.setOnClickListener(this);

    }

    fun setText(){
        counterOutput?.text = counter.toString() ?: "";
    }

    fun buttonOne(view: View) {
        counter += 1
        setText()
    }

    override fun onClick(view: View?) {
        counter += 3
        setText()

    }
}