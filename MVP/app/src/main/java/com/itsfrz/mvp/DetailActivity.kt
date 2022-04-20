package com.itsfrz.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itsfrz.mvp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    var _binding : ActivityMainBinding? = null
    val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}