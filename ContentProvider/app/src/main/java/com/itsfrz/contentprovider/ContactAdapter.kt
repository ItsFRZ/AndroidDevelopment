package com.itsfrz.contentprovider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val contactList: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private lateinit var contactCommunicator : ContactCommunicator

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contacts_item_layout,parent,false)
        val contactViewHolder = ContactViewHolder(view)

        contactCommunicator = parent.context as ContactCommunicator
        view.setOnClickListener {
            contactCommunicator.getData(contactList[contactViewHolder.adapterPosition].contactName)
        }

        view.setOnLongClickListener {
            ContactProvider.deleteContact(parent.context,contactViewHolder.adapterPosition,contactList[contactViewHolder.adapterPosition].contactName)
            contactList.removeAt(contactViewHolder.adapterPosition)
            notifyItemRemoved(contactViewHolder.adapterPosition)
            true
        }

        return contactViewHolder
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        with(holder){
            contactName.text = contactList[position].contactName
            contactNumber.text = contactList[position].contactNumber
        }

    }

    override fun getItemCount(): Int = contactList.size

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactName : TextView = itemView.findViewById(R.id.contactName)
        val contactNumber : TextView = itemView.findViewById(R.id.contactNumber)

    }

}
