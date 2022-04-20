package com.itsfrz.activitylaunchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        Log.d(ACTIVITYLOG,  "CREATED: " + javaClass.simpleName + " -- TASK ID: " + taskId);

    }

    fun one(view: View) {
        val intent = Intent(this, OneActivity::class.java)
        startActivity(intent)
    }
    fun two(view: View) {

        val intent = Intent(this, TwoActivity::class.java)
        startActivity(intent)
    }
    fun three(view: View) {

        val intent = Intent(this, ThreeActivity::class.java)
        startActivity(intent)
    }
    fun four(view: View) {

        val intent = Intent(this, FourActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ACTIVITYLOG, "DESTROYED: " + javaClass.simpleName + " -- TASK ID: " + taskId)
    }

}