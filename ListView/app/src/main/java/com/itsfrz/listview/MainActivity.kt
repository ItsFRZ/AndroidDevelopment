package com.itsfrz.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.itsfrz.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter : ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.list_item_fruit,
            R.id.fruitName,
            getFruitsData()
        )

        binding.listFruits.adapter = adapter

        binding.listFruits.setOnItemClickListener{
            parent, view,position,id ->

            val fruit = view as TextView
            Toast.makeText(this, "You selected ${fruit.text.toString()}", Toast.LENGTH_SHORT).show()
        }


    }

    private fun getFruitsData(): Array<String> {
        return arrayOf(
            "Orange",
            "Apple",
            "Grapes",
            "Pineapple",
            "Sugarcane",
            "Water-Mellon",
            "Strawberry",
            "Pomegranate",
            "Jack Fruit",
            "Guava",
            "Papaya",
            "Banana"

        )
    }
}