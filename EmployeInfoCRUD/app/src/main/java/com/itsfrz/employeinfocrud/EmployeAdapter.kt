package com.itsfrz.employeinfocrud

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeAdapter(val context : Context, val employeList : ArrayList<Employe>) :
    RecyclerView.Adapter<EmployeAdapter.EmployeViewHolder>(){


        inner class EmployeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val age : TextView = itemView.findViewById(R.id.employeAge);
            val name : TextView = itemView.findViewById(R.id.employeName);
            val id : TextView = itemView.findViewById(R.id.employeId);
            val gender : TextView = itemView.findViewById(R.id.employeGender);

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.employee_list_items,parent,false);
        return EmployeViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: EmployeViewHolder, position: Int) {
        with(holder){
            age.text = employeList[position].age
            id.text = employeList[position].id
            gender.text = employeList[position].gender.toString()
            name.text = employeList[position].name

        }
        holder.itemView.setOnLongClickListener {
            employeList.removeAt(position)
            notifyItemRemoved(position)
            true
        }


    }

    override fun getItemCount(): Int = employeList.size

}

