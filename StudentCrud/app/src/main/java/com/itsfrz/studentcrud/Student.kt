package com.itsfrz.studentcrud

data class Student(
    val studentName : String,
    val branch : String,
    val year : String,
    val subjects : ArrayList<Subject>
)