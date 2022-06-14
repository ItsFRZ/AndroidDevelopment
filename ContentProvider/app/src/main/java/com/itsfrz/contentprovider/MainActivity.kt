package com.itsfrz.contentprovider

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : BaseActivity() , ContactCommunicator{

    private lateinit var contactList : ArrayList<Contact>
    private lateinit var updateButton : Button
    private lateinit var createButton : Button
    private lateinit var changeContactName : EditText
    private lateinit var changeContactNumber : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateButton = findViewById(R.id.updateButton)
        createButton = findViewById(R.id.createButton)
        changeContactName = findViewById(R.id.changeName)
        changeContactNumber= findViewById(R.id.changeMobile)
        contactList = ContactProvider.getContactList(this);
        setupRecyclerView(contactList)
        createButton.setOnClickListener {
            val name : String = changeContactName.text.toString()
            val number : String = changeContactNumber.text.toString()
            ContactProvider.createContact(this,name,number)
        }

    }




    private fun setupRecyclerView(contactList: ArrayList<Contact>) {
        val contactRecyclerView = findViewById<RecyclerView>(R.id.contactsRecyclerView)
        contactRecyclerView.adapter = ContactAdapter(contactList)
        contactRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun getData(contactName: String) {

        changeContactName.setText(contactName)
        updateButton.setOnClickListener {
            if (contactName.length > 0){
                ContactProvider.updateContact(this,contactName,changeContactName.text.toString())
            }
        }
    }


}