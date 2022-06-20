package com.itsfrz.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val name : String,
    val number : String,
    val address : String,
    val age : String,
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L
)