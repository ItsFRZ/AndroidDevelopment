package com.itsfrz.todolist

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.itsfrz.todolist.Database.MyDbHelper
import com.itsfrz.todolist.Database.TodoTable
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var addbutton: Button
    private lateinit var todoField: EditText
    private lateinit var todoListView: ListView
//    private val todoData: ArrayList<Todo> = ArrayList();
    private val todoData = ArrayList<Todo>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();

        val todoAdapter = ArrayAdapter<Todo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todoData
        )

        val db = MyDbHelper(this).writableDatabase
        fun refreshTodoList(){
            val todos = TodoTable.getAllTodos(db)
            todoData.clear()
            todoData.addAll(todos)
            todoAdapter.notifyDataSetChanged()
            Log.d("TODOS", "refreshTodoList: ${todos.toString()}")
        }

        todoListView.adapter = todoAdapter
        refreshTodoList()

        addbutton.setOnClickListener {
            val newTodo = Todo(
                todoField.text.toString(),
                false
            )
            TodoTable.insertTodo(db,newTodo)
            Toast.makeText(this, "Resolution is Added @ ${Calendar.getInstance().time}", Toast.LENGTH_SHORT).show()
            refreshTodoList()
            todoAdapter.notifyDataSetChanged()
        }



    }



    private fun initView() {
        addbutton = findViewById(R.id.addButton)
        todoField = findViewById(R.id.todoInput)
        todoListView = findViewById(R.id.todoListView)
    }

}