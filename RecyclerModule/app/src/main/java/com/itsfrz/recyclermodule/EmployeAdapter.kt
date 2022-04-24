package com.itsfrz.recyclermodule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeAdapter(val employeList : ArrayList<Employee>): RecyclerView.Adapter<EmployeAdapter.CountryViewHolder>(){

    class CountryViewHolder(view : View) : RecyclerView.ViewHolder(view){
         val empName : TextView = view.findViewById(R.id.employeNameItem)
         val empDomain : TextView = view.findViewById(R.id.employeDomainItem)
         val empCompany : TextView = view.findViewById(R.id.employeCompanyItem)
         val empPosition : TextView = view.findViewById(R.id.employePositionItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.employe_list_item,parent,false);
        return CountryViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        with(holder){
            this.empName.text = employeList.get(position).name
            this.empDomain.text = employeList.get(position).domain
            this.empCompany.text = employeList.get(position).company
            this.empPosition.text = employeList.get(position).position
        }
    }

    override fun getItemCount(): Int = employeList.size

    override fun getItemId(position: Int): Long = employeList.get(position).name.hashCode().toLong()

}