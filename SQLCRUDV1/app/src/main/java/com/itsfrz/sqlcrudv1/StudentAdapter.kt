package com.itsfrz.sqlcrudv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StudentAdapter(val studentList : ArrayList<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.student_list_item,parent,false
        )

        return StudentViewHolder(view);
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        with(holder){
            outputName.text = studentList[position].name
            outputAge.text = studentList[position].age
            outputBranch.text = studentList[position].branch
            outputRoll.text = studentList[position].rollNo
            outputSemester.text = studentList[position].semester
        }
    }

    override fun getItemCount(): Int = studentList.size

    inner class StudentViewHolder(itemView: View) : ViewHolder(itemView){

        val outputName : TextView = itemView.findViewById(R.id.studentName)
        val  outputAge : TextView = itemView.findViewById(R.id.studentAge)
        val  outputBranch : TextView = itemView.findViewById(R.id.studentBranch)
        val  outputSemester : TextView = itemView.findViewById(R.id.studentSemester)
        val  outputRoll : TextView = itemView.findViewById(R.id.studentRoll)
        
    }

}
