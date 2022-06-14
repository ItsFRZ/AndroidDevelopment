package com.itsfrz.recyclervievrevision12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var studentName : TextView
    lateinit var studentAge : TextView
    lateinit var studentBranch : TextView
    lateinit var studentYear : TextView
    lateinit var studentRecyclerView : RecyclerView
    lateinit var studentAdapter: StudentAdapter
    lateinit var addNewStudent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        val studentData = GenerateDataset().getRandomStudent(5)
        setupStudentRecycler(studentData);


        addStudent(studentData)



    }

    private fun addStudent(studentData : ArrayList<Student>) {

        addNewStudent.setOnClickListener {
            if (checkEmptyOrWrong()){
                val student = Student(studentName.text.toString(),studentAge.text.toString().toInt(),studentBranch.text.toString(),studentYear.text.toString().toInt(),ArrayList<Skill>())
                studentData.add(student)
                with(studentRecyclerView){
                    adapter!!.notifyDataSetChanged()
                    scrollToPosition(studentData.size-1)
                    clearInput()
                }

            }
        }

    }


    private fun clearInput(){
        studentName.text = ""
        studentAge.text = ""
        studentBranch.text = ""
        studentYear.text = ""
    }

    private fun checkEmptyOrWrong(): Boolean {
        if(studentName.text.toString().length == 0){
            Toast.makeText(this, "Student Name Field is Empty", Toast.LENGTH_SHORT).show()
            return false
        }
        if(studentAge.text.toString().length == 0){
            Toast.makeText(this, "Student Age Field is Empty", Toast.LENGTH_SHORT).show()
            return false
        }
        if (studentAge.text.toString().toInt() < 18){
            Toast.makeText(this, "Invalid Student Age", Toast.LENGTH_SHORT).show()
            return false
        }
        if(studentBranch.text.toString().length == 0){
            Toast.makeText(this, "Student Branch Field is Empty", Toast.LENGTH_SHORT).show()
            return false
        }
        if(studentYear.text.toString().length == 0){
            Toast.makeText(this, "Student Year Field is Empty", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun initView() {
        studentName = findViewById(R.id.inputName)
        studentAge = findViewById(R.id.inputAge)
        studentBranch = findViewById(R.id.inputBranch)
        studentYear = findViewById(R.id.inputYear)
        addNewStudent = findViewById(R.id.addStudent);
        studentRecyclerView = findViewById<RecyclerView>(R.id.studentRecyclerView);

    }

    private fun setupStudentRecycler(studentData : ArrayList<Student>) {

        studentAdapter = StudentAdapter(studentData)
        with(studentRecyclerView){
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


    }


}