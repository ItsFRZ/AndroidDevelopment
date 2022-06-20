package com.itsfrz.todov1

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RelativeLayout
import androidx.appcompat.widget.Toolbar
import com.itsfrz.todov1.fragments.AddTodoFragment
import com.itsfrz.todov1.fragments.FragmentCommunicator
import com.itsfrz.todov1.fragments.HistoryFragment
import com.itsfrz.todov1.fragments.TodoFragment

class MainActivity : AppCompatActivity(), FragmentCommunicator {

    private lateinit var fragmentContainer : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFC61B")))
        actionBar?.hide()
        setContentView(R.layout.activity_main)
        initView()
        onCreateTodoFragment()
    }

    private fun initView() {
        fragmentContainer = findViewById(R.id.fragmentContainer)
    }



    private fun onCreateTodoFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val todoFragment = TodoFragment()
        fragmentTransaction.replace(R.id.fragmentContainer,todoFragment)
        fragmentTransaction.commit()
    }

    override fun routeFromTodoToHistory() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val historyFragment = HistoryFragment()
        fragmentTransaction.replace(R.id.fragmentContainer,historyFragment)
        fragmentTransaction.addToBackStack("History Fragment")
        fragmentTransaction.commit()

    }

    override fun routeFromTodoToAddTodo() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val addTodoFragment = AddTodoFragment()
        fragmentTransaction.replace(R.id.fragmentContainer,addTodoFragment)
        fragmentTransaction.addToBackStack("Add Fragment")
        fragmentTransaction.commit()


    }

    override fun routeFromAddTodoToTodo() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val todoFragment = TodoFragment()
        fragmentTransaction.replace(R.id.fragmentContainer,todoFragment)
        fragmentTransaction.commit()
    }
}