package com.itsfrz.authentication.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.itsfrz.authentication.model.User

object UserTable {
    val TABLE_NAME = "User"

    object Columns{

        val USER_ID = "Id"
        val USER_NAME = "Username"
        val USER_PASSWORD = "Password"

    }

    val CMD_CREATE_TABLE =
        """
            CREATE TABLE IF NOT EXISTS $TABLE_NAME(
                ${Columns.USER_ID} INTEGER NOT NULL PRIMARY KEY AUTOiNCREMENT,
                ${Columns.USER_NAME} TEXT NOT NULL,
                ${Columns.USER_PASSWORD} TEXT NOT NULL
            );
        """.trimIndent()


    fun insertUser(user : User,db : SQLiteDatabase){
        val contentValue = ContentValues()
        contentValue.put(Columns.USER_NAME,user.username)
        contentValue.put(Columns.USER_PASSWORD,user.password)
        db.insert(TABLE_NAME,null,contentValue)
        Log.d("INSERT", "insertUser: ${contentValue.toString()}")
    }

    // Fetch Specific row from database
    // Watch Codetutor playlist

    fun getUser(username : String,password : String,db : SQLiteDatabase) : User{
        val selection = "${Columns.USER_NAME}=? AND ${Columns.USER_PASSWORD}=?"
        val selectionArgs = arrayOf<String>(username,password)
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(Columns.USER_ID,Columns.USER_NAME,Columns.USER_PASSWORD),
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        val userData = arrayListOf<User>()
        while (cursor.moveToNext()){
            val userInstance = User(
                cursor.getString(1),
                cursor.getString(2)
            )
            userData.add(userInstance)
        }
        if (userData.size <= 0)
            return User("","")
        return userData.get(0)
    }



}