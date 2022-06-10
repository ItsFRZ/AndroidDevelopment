package com.itsfrz.androidspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sriyank.spinner.Countries

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val simpleSpinner: Spinner = findViewById(R.id.simpleSpinner)
        setUpSimpleSpinner(simpleSpinner)

        val customSpinner : Spinner = findViewById(R.id.customSpinner)
        setUpCustomSpinner(customSpinner)
    }

    private fun setUpCustomSpinner(customSpinner : Spinner) {
        val adapter = CountryArrayAdapter(this,Countries.list!!)
        customSpinner.adapter = adapter
    }

    private fun setUpSimpleSpinner(simpleSpinner: Spinner) {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        simpleSpinner.adapter = adapter

        simpleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                Toast.makeText(this@MainActivity, "$selectedItem Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "No item is selected please select the country", Toast.LENGTH_SHORT).show()
            }

        }
    }
}