package com.itsfrz.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

class StudentAdapter(private val studentList: ArrayList<Student>) : BaseAdapter(){
    override fun getCount(): Int {

        return studentList.size
    }

    override fun getItem(position: Int): Student {
        return studentList[position]
    }

    override fun getItemId(position: Int): Long {
        return studentList[position].rollNo.hashCode().toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val convertView : View
        val viewHolder : ViewHolder
        if(view == null){

            convertView = LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.student_item,
                    parent,
                    false
                )
            viewHolder = ViewHolder()
            with(viewHolder){
                studentName = convertView.findViewById(R.id.item_name)
                studentAge = convertView.findViewById(R.id.item_age)
                studentAddress = convertView.findViewById(R.id.item_address)
                studentBranch = convertView.findViewById(R.id.item_branch)
                studentRoll = convertView.findViewById(R.id.item_roll)
                studentCollege = convertView.findViewById(R.id.item_college)
                convertView.tag = this
            }

        }else{
            convertView = view // use already intiated view
            viewHolder = convertView.tag as ViewHolder

        }

        with(viewHolder){
            studentName.text = getItem(position).name
            studentAge.text = getItem(position).age
            studentRoll.text = getItem(position).rollNo
            studentAddress.text = getItem(position).address
            studentCollege.text = getItem(position).college
            studentBranch.text = getItem(position).branch
        }


        return convertView
    }

    /*



        val studentName : TextView = convertView?.findViewById(R.id.item_name) as TextView
        val studentAge : TextView = convertView?.findViewById(R.id.item_age) as TextView
        val studentRoll : TextView = convertView?.findViewById(R.id.item_roll) as TextView
        val studentAddress : TextView = convertView?.findViewById(R.id.item_address) as TextView
        val studentCollege : TextView = convertView?.findViewById(R.id.item_college) as TextView
        val studentBranch : TextView = convertView?.findViewById(R.id.item_branch) as TextView

        studentName.text = getItem(position).name
        studentAge.text = getItem(position).age
        studentRoll.text = getItem(position).rollNo
        studentAddress.text = getItem(position).address
        studentCollege.text = getItem(position).college
        studentBranch.text = getItem(position).branch



     */
    private class ViewHolder{
        lateinit var studentName: TextView
        lateinit var studentAge: TextView
        lateinit var studentRoll: TextView
        lateinit var studentAddress: TextView
        lateinit var studentCollege: TextView
        lateinit var studentBranch: TextView

    }

}