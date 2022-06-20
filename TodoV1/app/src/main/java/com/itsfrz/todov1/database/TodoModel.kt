package com.itsfrz.todov1.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoModel (
    val title : String,
    val description : String,
    val category: String,
    val date : Long,
    val time : Long,
    val isFinished : Int = -1,
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L
)