package com.itsfrz.mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itsfrz.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var _binding : ActivityMainBinding? = null
    val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.sendButton.setOnClickListener {
            val myMessage = binding.inputMessage.text.toString().trim()
            val intent = Intent(this@MainActivity,DetailActivity::class.java)
            intent.putExtra("message",myMessage)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}