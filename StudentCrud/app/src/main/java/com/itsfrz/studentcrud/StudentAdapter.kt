package com.itsfrz.studentcrud

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val studentList : ArrayList<Student>,val context : Context) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>()  {

    class StudentViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val studentNameView : TextView = view.findViewById(R.id.studentItemName)
        val studentBranchView : TextView = view.findViewById(R.id.studentItemBranch)
        val studentYearView : TextView = view.findViewById(R.id.studentItemYear);
        val studentItemRow : LinearLayout = view.findViewById(R.id.studentItemRow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item,parent,false);

        return StudentViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        holder.apply {
            this.studentNameView.text = studentList.get(position).studentName
            this.studentBranchView.text = studentList.get(position).branch
            this.studentYearView.text = studentList.get(position).year
        }

        holder.studentItemRow.setOnClickListener {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.action_student_item)

            val studentName : EditText = dialog.findViewById(R.id.studentAddItemName)
            val studentBranch : EditText = dialog.findViewById(R.id.studentAddItemBranch)
            val studentYear : EditText = dialog.findViewById(R.id.studentAddItemYear)
            val updateButton : Button = dialog.findViewById(R.id.studentAddButton)
            updateButton.setText("Update")

            studentName.setText(studentList.get(position).studentName)
            studentBranch.setText(studentList.get(position).branch)
            studentYear.setText(studentList.get(position).year)

            updateButton.setOnClickListener {
                val updatedStudent = Student(
                    studentName.text.toString(),
                    studentBranch.text.toString(),
                    studentYear.text.toString(),
                    arrayListOf(
                        Subject("","")
                    )
                )
                studentList.set(position,updatedStudent)
                notifyItemChanged(position)
                dialog.dismiss()
            }

            dialog.show()


        }


        holder.studentItemRow.setOnLongClickListener{
            studentList.removeAt(position)
            notifyDataSetChanged()
            true
        }


    }

    override fun getItemCount(): Int = studentList.size
}