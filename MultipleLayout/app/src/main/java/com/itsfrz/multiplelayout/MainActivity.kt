package com.itsfrz.multiplelayout

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itsfrz.multiplelayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentActionListener {

    private var _binding : ActivityMainBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            attachDefaultFragment(R.id.fragmentContainer)
        }else{
            attachDefaultFragment(R.id.fragmentOneContainer)
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.fragmentTwoContainer,TwoFragment())
                .commit()
        }



    }

    private fun attachDefaultFragment(containerId : Int) {

        var myContainerId : Int = 0
        if(R.id.fragmentContainer == containerId)
            myContainerId = containerId
        else
            myContainerId = R.id.fragmentOneContainer

        val fragmentOne = OneFragment()
        fragmentOne.setActionListener(this)
        supportFragmentManager.beginTransaction()
            .add(myContainerId,fragmentOne)
            .commit()
    }

    override fun sendAction(bundle: Bundle) {

        val fragmentTwo = TwoFragment()
        fragmentTwo.arguments = bundle
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.fragmentContainer,fragmentTwo)
                .commit()
        }else{
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentTwoContainer,fragmentTwo)
                .commit()
        }
    }


}