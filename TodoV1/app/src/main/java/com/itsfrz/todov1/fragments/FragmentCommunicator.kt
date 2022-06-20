package com.itsfrz.todov1.fragments

interface FragmentCommunicator {
    fun routeFromTodoToHistory()
    fun routeFromTodoToAddTodo()
    fun routeFromAddTodoToTodo()
}