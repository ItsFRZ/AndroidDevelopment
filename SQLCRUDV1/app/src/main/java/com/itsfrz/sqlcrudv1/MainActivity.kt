package com.itsfrz.sqlcrudv1

import android.app.Dialog
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itsfrz.sqlcrudv1.Database.LocalDatabaseHelper
import com.itsfrz.sqlcrudv1.Database.StudentTable

class MainActivity : AppCompatActivity() {

    private val studentList = ArrayList<Student>()
    private lateinit var addStudentButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
        val studentRecyclerView = findViewById<RecyclerView>(R.id.studentRecyclerView)
        val studentDB: SQLiteDatabase = LocalDatabaseHelper(this).writableDatabase
        setUpRecyclerView(studentRecyclerView);
        refreshStudentData(studentList,studentDB,studentRecyclerView)
        addStudent(studentRecyclerView,studentDB)




    }

    private fun refreshStudentData(studentList: ArrayList<Student>, studentDB: SQLiteDatabase,studentRecyclerView : RecyclerView) {
        val studentListFromDb = StudentTable.getStudents(studentDB)
        Log.d("REFRESHDB", "refreshStudentData: ${studentListFromDb}")

        studentList.clear()
        studentList.addAll(studentListFromDb)
        studentRecyclerView.adapter?.notifyDataSetChanged()
    }

    private fun addStudent(studentRecyclerView : RecyclerView,studentDB : SQLiteDatabase) {
        addStudentButton.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.student_add_layout)
            dialog.show()
            dialog.setCancelable(false)

            val nameInput : EditText = dialog.findViewById(R.id.studentNameInput)
            val ageInput : EditText = dialog.findViewById(R.id.studentAgeInput)
            val branchInput : EditText = dialog.findViewById(R.id.studentBranchInput)
            val semesterInput : EditText = dialog.findViewById(R.id.studentSemesterInput)
            val rollNoInput : EditText = dialog.findViewById(R.id.studentRollInput)
            val studentRegisterButton : Button = dialog.findViewById(R.id.addAllInputButton)
            if (checkValidations(nameInput,ageInput,branchInput,semesterInput,rollNoInput)){
                studentRegisterButton.setOnClickListener {
                    val student : Student = getStudentInstance(nameInput,ageInput,branchInput,semesterInput,rollNoInput)
                    studentList.add(student)
                    studentRecyclerView.adapter?.notifyItemInserted(studentList.size-1)
                    // store student data to db
                    StudentTable.insertStudent(student,studentDB)
                    //dismiss dialog
                    dialog.dismiss()
                }
            }


        }
    }

    private fun getStudentInstance(nameInput: EditText, ageInput: EditText, branchInput: EditText, semesterInput: EditText, rollNoInput: EditText): Student {
        return Student(
            nameInput.text.toString(),
            ageInput.text.toString(),
            rollNoInput.text.toString(),
            semesterInput.text.toString(),
            branchInput.text.toString()
        )
    }

    private fun checkValidations(nameInput: EditText, ageInput: EditText, branchInput: EditText, semesterInput: EditText, rollNoInput: EditText): Boolean {
        if (nameInput.text.toString().length < 0)
            return false
        else if (ageInput.text.toString().length < 0)
            return false
        else if (branchInput.text.toString().length < 0)
            return false
        else if (rollNoInput.text.toString().length < 0)
            return false
        else if (semesterInput.text.toString().length < 0)
            return false
        return true
    }

    private fun initView() {
        addStudentButton = findViewById(R.id.addStudentButton);
    }

    private fun setUpRecyclerView(studentRecyclerView : RecyclerView) {
        studentRecyclerView.adapter = StudentAdapter(studentList)
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
        studentRecyclerView.setHasFixedSize(true)
    }

}