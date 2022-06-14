package com.itsfrz.authentication.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itsfrz.authentication.R
import com.itsfrz.authentication.model.Contact

class ContactAdapter(val contactList: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        val contactViewHolder = ContactViewHolder(view)

        return contactViewHolder
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        with(holder){
            contactName.text = contactList[position].contactName
        }

    }

    override fun getItemCount(): Int = contactList.size

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactName : TextView = itemView.findViewById(R.id.contactName)
        val contactImage : ImageView = itemView.findViewById(R.id.contactImage)


    }

}
