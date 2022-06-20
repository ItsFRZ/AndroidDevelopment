package com.itsfrz.todov1.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert
    suspend fun insertTodo(todo : TodoModel) : Long

    // Change
    @Query("SELECT * FROM TodoModel WHERE isFinished = -1")
    fun getUnFinishedTodo() : LiveData<List<TodoModel>>

    @Query("UPDATE TodoModel SET isFinished = 1 WHERE id=:uid")
    fun finishTodo(uid : Long)

    @Query("DELETE FROM TodoModel WHERE id=:uid")
    fun deleteTodo(uid : Long)


}