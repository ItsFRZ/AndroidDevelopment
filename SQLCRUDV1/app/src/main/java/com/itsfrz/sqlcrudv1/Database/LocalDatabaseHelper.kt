package com.itsfrz.sqlcrudv1.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

object LocalDatabaseHelperConfig{
    val databaseName : String = "Student.db"
    val databaseVersion : Int = 1
}

class LocalDatabaseHelper(context : Context) : SQLiteOpenHelper(
    context,
    LocalDatabaseHelperConfig.databaseName,
    null,
    LocalDatabaseHelperConfig.databaseVersion
) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(StudentTable.CMD_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}