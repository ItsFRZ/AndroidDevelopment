package com.itsfrz.syntheticviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itsfrz.syntheticviewbinding.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {

    private var _binding : ActivityViewBindingBinding? = null
    private val binding
        get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.myViewBindingText.text = "Hello World!"
        initFragment()

    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.viewBindingFragmentContainer,ViewBindingFragment())
            .commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
