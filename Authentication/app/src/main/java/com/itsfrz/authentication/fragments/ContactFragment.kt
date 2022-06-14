package com.itsfrz.authentication.fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itsfrz.authentication.AuthenticationCommunicator
import com.itsfrz.authentication.MainActivity
import com.itsfrz.authentication.R
import com.itsfrz.authentication.adapters.ContactAdapter
import com.itsfrz.authentication.database.PreferenceRespository
import com.itsfrz.authentication.model.Contact
import com.itsfrz.authentication.provider.ContactProvider

class ContactFragment : Fragment() {

    private lateinit var communicator: AuthenticationCommunicator
    private val preferenceRespository by lazy {
        PreferenceRespository(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true);
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        communicator = activity as AuthenticationCommunicator
        val contactList = ContactProvider.getContactList(requireContext())
        setupRecyclerView(contactList,view)


        return view;
    }

    override fun onResume() {
        super.onResume()
        (requireContext() as AppCompatActivity).supportActionBar!!.show()

    }

    override fun onDestroy() {
        super.onDestroy()
        (requireContext() as AppCompatActivity).supportActionBar!!.hide()
    }


    private fun logoutUser() {
        preferenceRespository.clearUser()
    }

    private fun setupRecyclerView(contactList: ArrayList<Contact>,view : View) {
        val contactRecyclerView = view.findViewById<RecyclerView>(R.id.contactRecyclerView)
        contactRecyclerView.adapter = ContactAdapter(contactList)
        contactRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.item_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.username_status_menu){
            communicator.routeFromContactToLandingPage()
        }
        if (itemId == R.id.logout_status_menu){
            logoutUser()
            contactToActivity()
        }
        if(itemId == R.id.add_user_menu){
            val dialog = Dialog(requireContext())

        }
        return true
    }

    private fun contactToActivity() {
        val intent = Intent(requireContext(),MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }







}