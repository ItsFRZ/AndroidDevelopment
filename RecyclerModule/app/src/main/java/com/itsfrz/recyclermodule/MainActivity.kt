package com.itsfrz.recyclermodule

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val employeeList = getRandomEmployes(100)
        Log.d(TAG, "onCreate: ${employeeList}")


        val employeList : RecyclerView = findViewById<RecyclerView>(R.id.employeListRecycler).apply {
            layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
            adapter = EmployeAdapter(employeeList).apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }



    }






    private val employeeName = arrayOf<String>(
        "Adarsh",
        "Nishant",
        "Abhijeet",
        "Shumeel",
        "Fredrick",
        "Robin",
        "Alex",
        "Ron",
        "Samson",
        "Robert"
    )
    private val employeeDomain = arrayOf<String>(
        "Android Engineer",
        "Full Stack Engineer",
        "Web Developer",
        "MERN Stack developer",
        "MEAN stack Developer",
        "IOS Engineer",
        "React Developer",
        "Backend Engineer",
        "Frontend Specialist",
        "Tester"
    )

    private val employeePosition = arrayOf<String>(
        "Junior Software Engineer",
        "Software Engineer",
        "Level 1 Software Engineer",
        "Level 2 Software Engineer",
        "Level 3 Software Engineer",
        "Level 4 Software Engineer",
        "Level 5 Software Engineer",
        "Level 6 Software Engineer",
        "Software Architect",
        "Chief Technology Officer"
    )


    private val employeeCompany = arrayOf<String>(
        "FULL Creative",
        "Amazon",
        "Google",
        "Zoho",
        "Zomato",
        "Meta",
        "Uber",
        "Apple",
        "Stripe",
        "Flipkart"
    );
    fun getRandomEmployes(noe : Int) : ArrayList<Employee>{

        val employeeList = ArrayList<Employee>()
        val randomEmployee = Random(10)
        for (i in 0 until noe){

            val employee = Employee(
                employeeName[randomEmployee.nextInt(10)],
                employeeDomain[randomEmployee.nextInt(10)],
                employeeCompany[randomEmployee.nextInt(10)],
                employeePosition[randomEmployee.nextInt(10)]);
            employeeList.add(employee)
        }



        return employeeList
    }


}