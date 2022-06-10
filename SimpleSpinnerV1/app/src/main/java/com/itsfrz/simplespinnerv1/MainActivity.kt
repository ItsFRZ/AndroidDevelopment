package com.itsfrz.simplespinnerv1

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get

enum class Colour(val value : Int){
    Red(Color.RED),
    Blue(Color.BLUE),
    Yellow(Color.YELLOW),
    Cyan(Color.CYAN),
    DarkGray(Color.DKGRAY),
    MAGENTA(Color.MAGENTA),
    Green(Color.GREEN)
}

class MainActivity : AppCompatActivity() {

    private val simpleSpinner: Spinner by lazy {
        findViewById(R.id.simpleSpinner)
    }

    private val mainActivityLayout : ConstraintLayout by lazy {
        findViewById(R.id.mainActivityLayout)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpSimpleSpinner();



    }

    private fun setUpSimpleSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.Colour,
            android.R.layout.simple_spinner_item
        )
        simpleSpinner.adapter = adapter
        simpleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val layoutColor: String = parent!!.getItemAtPosition(position).toString()
                val colorValue = getValue(layoutColor);
                mainActivityLayout.setBackgroundColor(colorValue)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }


    private fun getValue(layoutColor: String): Int {
        var value = Color.BLACK
        for(v in Colour.values()){
            if (v.name.equals(layoutColor))
                value = v.value
        }
        return value
    }
}