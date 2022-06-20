package com.itsfrz.todov1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.itsfrz.todov1.R
import com.itsfrz.todov1.database.TodoModel
import java.text.SimpleDateFormat
import kotlin.random.Random

class TodoAdapter(val context: Context, val todoList: ArrayList<TodoModel>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val showTitle = itemView.findViewById<TextView>(R.id.showTitle)
        val showDescription = itemView.findViewById<TextView>(R.id.showDescription)
        val showCategory = itemView.findViewById<TextView>(R.id.showCategory)
        val showTime = itemView.findViewById<TextView>(R.id.showTime)
        val showDate = itemView.findViewById<TextView>(R.id.showDate)
        val colorTag = itemView.findViewById<RelativeLayout>(R.id.colorTag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_item_layout, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        with(holder) {
            val colors = itemView.resources.getIntArray(R.array.random_color)
            val randomColor = colors[Random.nextInt(colors.size)]
            this.colorTag.setBackgroundColor(randomColor)
            this.showCategory.text = todoList[position].category
            this.showDescription.text = todoList[position].description
            this.showTitle.text = todoList[position].title
//            updateTime(this.showTime, todoList[position].time)
//            updateDate(this.showDate, todoList[position].date)


        }
    }

    private fun updateDate(showDate: TextView, date: Long) {
        // EEE, 5 Jan 2020
        val myFormat = "EEE, d MM yyyy"
        val simpleDateFormat = SimpleDateFormat(myFormat)
        showDate.setText(simpleDateFormat.format(date))
    }

    private fun updateTime(showTime: TextView, time: Long) {

        // 4:00 am/pm
        val myFormat = "h:mm a"
        val simpleDateFormat = SimpleDateFormat(myFormat)
        showTime.text = simpleDateFormat.format(myFormat).toString()


    }


    override fun getItemCount(): Int = todoList.size


}

