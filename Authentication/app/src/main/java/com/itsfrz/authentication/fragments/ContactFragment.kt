package com.itsfrz.authentication.fragments

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.transition.MaterialContainerTransform
import com.itsfrz.authentication.AuthenticationCommunicator
import com.itsfrz.authentication.MainActivity
import com.itsfrz.authentication.R
import com.itsfrz.authentication.adapters.ContactAdapter
import com.itsfrz.authentication.adapters.PhoneTypeArrayAdapter
import com.itsfrz.authentication.animation.startAnimation
import com.itsfrz.authentication.database.PreferenceRespository
import com.itsfrz.authentication.model.Contact
import com.itsfrz.authentication.model.PhoneType
import com.itsfrz.authentication.model.PhoneTypes
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
        setupNewContact(view);


        communicator = activity as AuthenticationCommunicator
        val contactList = ContactProvider.getContactList(requireContext())
        setupRecyclerView(contactList,view)


        return view;
    }

    private fun setupNewContact(view : View) {

        val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.circle_explosion_animation).apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
        }


        val addNewContact = view.findViewById<FloatingActionButton>(R.id.addNewContact)
        val circleMotionView = view.findViewById<View>(R.id.circleMotionView)
        addNewContact.setOnClickListener {
            addNewContact.isVisible = false
            circleMotionView.isVisible = true
            circleMotionView.startAnimation(animation){
                communicator.routeFromContactToAddContact()
            }
            circleMotionView.isVisible = false
            addNewContact.isVisible = true
        }
    }






    override fun onResume() {
        super.onResume()
        (requireContext() as AppCompatActivity).supportActionBar!!.show()

    }

    override fun onPause() {
        super.onPause()
        (requireContext() as AppCompatActivity).supportActionBar!!.hide()
    }



    private fun logoutUser() {
        preferenceRespository.clearUser()
    }

    private fun setupRecyclerView(contactList: ArrayList<Contact>,view : View) {
        val contactRecyclerView = view.findViewById<RecyclerView>(R.id.contactRecyclerView)
        contactRecyclerView.adapter = ContactAdapter(requireContext(),contactList)
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

        return true
    }

    private fun contactToActivity() {
        val intent = Intent(requireContext(),MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }







}