package com.itsfrz.coroutinesv1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterText: TextView = findViewById(R.id.counterText)
        val buttonCounter: Button = findViewById(R.id.buttonCounter)
        val buttonLongTask1: Button = findViewById(R.id.buttonLongTask1)
        val buttonLongTask2: Button = findViewById(R.id.buttonLongTask2)
        val buttonLongTask3: Button = findViewById(R.id.buttonLongTask3)

        counterTextIncrease(buttonCounter, counterText)
        longRunningTask(buttonLongTask1)
        dataFetch(buttonLongTask2)
        longRunningTask(buttonLongTask3)


//        GlobalScope.launch(Dispatchers.IO) {
//            fetchData()
//        }


//        GlobalScope.launch(Dispatchers.Main) {
//            printFollowers()
//        }


        Log.d("FLOW", "onCreate: Thread Launch ")
        val job = GlobalScope.launch(Dispatchers.IO) {

            Log.d("FLOW", "onCreate: Request Initiated ")
            getData()
            Log.d("FLOW", "onCreate: Response Get ")
        }

        Log.d("FLOW", "onCreate: Thread End ")
    }


    suspend fun getData() {

        Log.d("FLOW", "getData: Data Request")
        delay(1000)
        Log.d("FLOW", "getData: Data as a Response")
    }
//
//    suspend fun getData(): Unit {
//
//        Log.d("SUSPEND", "getData: Network Request")
//        delay(1000)
//        Log.d("SUSPEND", "getData: Network Response")
//
//    }

    suspend fun printFollowers() {

        val fbJob = GlobalScope.async(Dispatchers.IO) {
            getFacebookFollowers()
        }
        val instaJob = GlobalScope.async(Dispatchers.IO) {
            getInstagramFollowers()
        }

        fbJob.await()
        instaJob.await()
        Log.d("FOLLOWERS", "printFollowers: FACEBOOK FOLLOWER ${fbJob.await()}")
        Log.d("FOLLOWERS", "printFollowers: INSTAGRAM FOLLOWER ${instaJob.await()}")
    }

    suspend fun getInstagramFollowers(): Int {
        delay(800)
        return 99
    }

    suspend fun getFacebookFollowers(): Int {
        delay(400)
        return 120
    }

    private fun dataFetch(buttonLongTask2: Button) {
        buttonLongTask2.setOnClickListener {

            GlobalScope.launch(Dispatchers.Default) {
                getDataFromServer()
            }

        }
    }

    private suspend fun getDataFromServer() {
        Log.d("FETCH", "dataFetch: Request For Data via ${Thread.currentThread().name}")
        delay(1000)
        Log.d("FETCH", "dataFetch: Response of Data via ${Thread.currentThread().name}")

    }

    private fun longRunningTask(buttonLongTask: Button) {
        Log.d("TAGID", "longRunningTask: ${buttonLongTask.id}")
        var sum = 0
        buttonLongTask.setOnClickListener {
            GlobalScope.launch(Dispatchers.Default) {
                for (i in 1..1001) {
                    sum += i
                }
                Log.d(
                    "SUM",
                    "longRunningTask: ${sum} calculated on ${Thread.currentThread().name} thread"
                )
                sum = 0
            }
        }

    }

    private fun counterTextIncrease(buttonCounter: Button, counterText: TextView) {
        buttonCounter.setOnClickListener {
            val count = counterText.text.toString().toInt()
            counterText.text = count.inc().toString()
        }
    }

    suspend fun fetchData() {
        Log.d("SUSPEND", "fetchData: Fetch Data from SQL DB")
        val job = GlobalScope.launch(Dispatchers.IO) {
            getData()
        }
        job.join()
        Log.d("SUSPEND", "fetchData: Fetch Data from NOSQL DB")
    }


}