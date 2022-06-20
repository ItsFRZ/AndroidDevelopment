package com.itsfrz.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "User.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username : TextView = findViewById(R.id.userName)
        val userAge : TextView = findViewById(R.id.userAge)
        val userNumber : TextView = findViewById(R.id.userNumber)
        val userAddress : TextView = findViewById(R.id.userAddress)
        val saveUser :Button = findViewById(R.id.saveUser)
        val fetchUser :Button = findViewById(R.id.fetchUser)

        saveUser.setOnClickListener {
          GlobalScope.launch(Dispatchers.IO) {
              db.userDao().insert(
                  User(
                      "Faraz Sheikh","7712128121","Nagpur","22"
                  )
              )
          }
        }

        fetchUser.setOnClickListener {


            db.userDao().getAllUser().observe(this,
            Observer {
                if (it.isNotEmpty()){
                    with(it[0]){
                        username.text = name
                        userNumber.text = number
                        userAddress.text = address
                        userAge.text = age

                    }
                }
            })


        }

    }
}