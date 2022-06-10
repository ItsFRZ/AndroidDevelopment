package com.itsfrz.todolist.Database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.itsfrz.todolist.Todo

object TodoTable {
    val TABLE_NAME = "Todo"
    object Columns{
        val ID = "Id"
        val TASK = "Task"
        val COMPLETED = "Completed"
    }

    val CMD_CREATE_TABLE = """CREATE TABLE IF NOT EXISTS $TABLE_NAME
        (
            ${Columns.ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
            ${Columns.TASK} TEXT,
            ${Columns.COMPLETED} BOOLEAN
        );
    """.trimMargin()

    fun insertTodo(db : SQLiteDatabase,todo : Todo) : Unit{
        val row = ContentValues()
        row.put(Columns.TASK,todo.task)
        row.put(Columns.COMPLETED,todo.completed)
        db.insert(TABLE_NAME,null,row)
    }

    fun getAllTodos(db : SQLiteDatabase) : ArrayList<Todo>{
        val todos = ArrayList<Todo>()
        var cursor =  db.query(
                TABLE_NAME,
                arrayOf(Columns.ID,Columns.TASK,Columns.COMPLETED),
                null,null,
                null,
                null,
                null
            )
        while (cursor.moveToNext()){
            val todo = Todo(
                cursor.getString(1),
                cursor.getInt(2) == 1
            )
            todos.add(todo)
        }
        return todos
    }

}