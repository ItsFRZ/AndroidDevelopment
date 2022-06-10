package com.itsfrz.recyclervievrevision12

data class Skill(val skill : String)

data class Student(
    val name : String,
    val age : Int,
    val branch : String,
    val year : Int,
    val skills : List<Skill>
)