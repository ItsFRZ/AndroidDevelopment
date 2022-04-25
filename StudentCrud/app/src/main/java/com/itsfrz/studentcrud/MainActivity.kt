package com.itsfrz.studentcrud

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var studentList : ArrayList<Student>
    lateinit var studentRecyclerView : RecyclerView
    lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentList = getDefaultStudent()
        studentRecyclerView = findViewById<RecyclerView>(R.id.studentRecyclerView)
        studentAdapter =  StudentAdapter(studentList,this)
        studentRecyclerView.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
        addStudents()


    }

    private fun addStudents() {
        val addButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        addButton.setOnClickListener {
            val dialog = Dialog(this@MainActivity)
            dialog.setContentView(R.layout.action_student_item)
            dialog.setCancelable(false)

            val studentName : EditText = dialog.findViewById(R.id.studentAddItemName)
            val studentBranch : EditText = dialog.findViewById(R.id.studentAddItemBranch)
            val studentYear : EditText = dialog.findViewById(R.id.studentAddItemYear)
            val studentAddButton : Button = dialog.findViewById(R.id.studentAddButton)

            studentAddButton.setOnClickListener {
                val name = studentName.text.toString()
                val branch = studentBranch.text.toString()
                val year = studentYear.text.toString()
                val student = Student(
                    name,
                    branch,
                    year,
                    arrayListOf<Subject>(
                        Subject("","")
                    )
                )

                studentList.add(student)
                studentAdapter.notifyItemInserted(studentList.size-1)
                studentRecyclerView.scrollToPosition(studentList.size-1)
                dialog.dismiss()
            }
            dialog.show()


        }
    }

    private fun getDefaultStudent(): ArrayList<Student> {
        return arrayListOf(
            Student("Faraz Sheikh","Computer Science","4th Year", arrayListOf(
                Subject("Image Processing","Pallavi"),
                Subject("Big Data","Reenu Saini"),
                Subject("Advanced Computer Architecture","Soniya Bajaj")
                )),

            Student("Alkesh Shende","Mechanical Engineering","4th Year", arrayListOf(
                Subject("",""),
            )),

            Student("Alex Jones","Electrical Engineering","3rd Year", arrayListOf(
                Subject("",""),
            )),

            Student("Robin Mine","Electrical Engineering","3rd Year", arrayListOf(
                Subject("",""),
            )),

            Student("Sharon Yajub","Aestro Physics & Engineering","2nd Year", arrayListOf(
                Subject("",""),
            )),

            Student("Reynold Harper","Electrical Engineering","3rd Year", arrayListOf(
                Subject("",""),
            )),

            Student("Kattie Jones","Electrical Engineering","4th Year", arrayListOf(
                Subject("",""),
            )),

            Student("Athar Sayyad","Mechanical Engineering","4th Year", arrayListOf(
                Subject("",""),
            )),
            Student("Akash Sharma","Civil Engineering","2nd Year", arrayListOf(
                Subject("",""),
            )),





            )
    }


}