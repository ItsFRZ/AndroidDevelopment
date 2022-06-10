package com.itsfrz.sqlcrudv1.Database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.itsfrz.sqlcrudv1.Student

object StudentTable{
    val TABLE_NAME = "Student"
    object Columns{
        val STUDENT_ID = "Id"
        val STUDENT_NAME = "Name"
        val STUDENT_AGE = "Age"
        val STUDENT_ROLL = "RollNo"
        val STUDENT_SEMESTER = "Semester"
        val STUDENT_BRANCH = "Branch"
    }

    val CMD_CREATE_TABLE = """
          
          CREATE TABLE IF NOT EXISTS $TABLE_NAME(
                ${Columns.STUDENT_ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
                ${Columns.STUDENT_NAME} TEXT,
                ${Columns.STUDENT_AGE} TEXT,
                ${Columns.STUDENT_ROLL} TEXT,
                ${Columns.STUDENT_SEMESTER} TEXT,
                ${Columns.STUDENT_BRANCH} TEXT
          );
          
    """.trimIndent()

    fun insertStudent(student : Student, db : SQLiteDatabase) : Unit{
        val contentValue = ContentValues()
        contentValue.put(Columns.STUDENT_AGE,student.age)
        contentValue.put(Columns.STUDENT_NAME,student.name)
        contentValue.put(Columns.STUDENT_ROLL,student.rollNo)
        contentValue.put(Columns.STUDENT_BRANCH,student.branch)
        contentValue.put(Columns.STUDENT_SEMESTER,student.semester)
        db.insert(TABLE_NAME,null,contentValue)
    }

    fun getStudents(db : SQLiteDatabase) :  ArrayList<Student>{
        val studentList: ArrayList<Student> = ArrayList<Student>()
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(Columns.STUDENT_ID,Columns.STUDENT_NAME,Columns.STUDENT_AGE,Columns.STUDENT_ROLL,Columns.STUDENT_SEMESTER,Columns.STUDENT_BRANCH),
            null,
            null,
            null,
            null,
            null
        )

        while (cursor.moveToNext()){
            val studentInstance = Student(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5)
            )
            studentList.add(studentInstance)

        }
        return studentList
    }

}