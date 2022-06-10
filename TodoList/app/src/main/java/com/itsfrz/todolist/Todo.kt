package com.itsfrz.todolist

data class Todo(val task : String,val completed : Boolean){
    override fun toString(): String {
        return this.task
    }
}