package com.itsfrz.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentAdapter(private val context : Context,private val studentList: ArrayList<Student>) : BaseAdapter(){
    override fun getCount(): Int {

        return studentList.size
    }

    override fun getItem(position: Int): Student {
        return studentList[position]
    }

    override fun getItemId(position: Int): Long {
        return studentList[position].rollNo.hashCode().toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        convertView = LayoutInflater.from(context)
            .inflate(
                R.layout.student_item,
                parent,
                false
            )

        val studentName : TextView = convertView.findViewById(R.id.item_name)
        val studentAge : TextView = convertView.findViewById(R.id.item_age)
        val studentRoll : TextView = convertView.findViewById(R.id.item_roll)
        val studentAddress : TextView = convertView.findViewById(R.id.item_address)
        val studentCollege : TextView = convertView.findViewById(R.id.item_college)
        val studentBranch : TextView = convertView.findViewById(R.id.item_branch)

        studentName.text = getItem(position).name
        studentAge.text = getItem(position).age
        studentRoll.text = getItem(position).rollNo
        studentAddress.text = getItem(position).address
        studentCollege.text = getItem(position).college
        studentBranch.text = getItem(position).branch


        return convertView
    }
}