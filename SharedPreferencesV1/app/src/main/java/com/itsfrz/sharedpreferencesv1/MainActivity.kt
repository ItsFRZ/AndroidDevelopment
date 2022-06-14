package com.itsfrz.sharedpreferencesv1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var redButton : Button
    lateinit var blueButton : Button
    lateinit var greenButton : Button
    lateinit var mainLayoutBackground : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
        loadUserSettings()
        buttonClick()

    }

    private fun loadUserSettings() {
        val sPreferences = this.getPreferences(MODE_PRIVATE)
        val myPreferenceColor = sPreferences.getInt("COLOR",Color.BLACK)
        setupLayout(myPreferenceColor,mainLayoutBackground)
    }

    private fun buttonClick() {

        redButton.setOnClickListener {
            setupPreferences(Color.RED,mainLayoutBackground)
        }

        blueButton.setOnClickListener {
            setupPreferences(Color.BLUE,mainLayoutBackground)
        }

        greenButton.setOnClickListener {
            setupPreferences(Color.GREEN,mainLayoutBackground)
        }
    }

    private fun setupLayout(color: Int,layout : LinearLayout){
        layout.setBackgroundColor(color)
    }

    private fun setupPreferences(color : Int,layout : LinearLayout){
        val spreferences = getPreferences(MODE_PRIVATE)
        val editor = spreferences.edit()
        editor.putInt("COLOR",color)
        editor.commit()
        setupLayout(color, layout)
    }

    private fun initView() {
        redButton = findViewById(R.id.redButton)
        blueButton = findViewById(R.id.blueButton)
        greenButton = findViewById(R.id.greenButton)
        mainLayoutBackground = findViewById(R.id.mainLayoutBackground)
    }



}