package com.itsfrz.recyclervievrevision12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter(val studentData : ArrayList<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {


    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.name)
        val age : TextView = itemView.findViewById(R.id.age)
        val branch : TextView = itemView.findViewById(R.id.branch)
        val year : TextView = itemView.findViewById(R.id.year)
        val delete : Button = itemView.findViewById(R.id.deleteButton)
        val update : Button = itemView.findViewById(R.id.updateButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val viewItems = LayoutInflater.from(parent.context).inflate(R.layout.student_data_items,parent,false)


        return StudentViewHolder(viewItems)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.name.text = studentData[position].name
        holder.age.text = studentData[position].age.toString()
        holder.branch.text = studentData[position].branch
        holder.year.text = studentData[position].year.toString()

        holder.delete.setOnClickListener {
            studentData.removeAt(position)
            notifyItemChanged(position)
            true
        }
 }


    override fun getItemCount(): Int = studentData.size

}