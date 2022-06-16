package com.itsfrz.authentication.fragments

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itsfrz.authentication.AuthenticationCommunicator
import com.itsfrz.authentication.MainActivity
import com.itsfrz.authentication.R
import com.itsfrz.authentication.adapters.ContactAdapter
import com.itsfrz.authentication.adapters.PhoneTypeArrayAdapter
import com.itsfrz.authentication.database.PreferenceRespository
import com.itsfrz.authentication.model.Contact
import com.itsfrz.authentication.model.PhoneType
import com.itsfrz.authentication.model.PhoneTypes
import com.itsfrz.authentication.provider.ContactProvider

class ContactFragment : Fragment() {

    private lateinit var communicator: AuthenticationCommunicator
    private val GALLERY_REQUEST_CODE = 0
    private val preferenceRespository by lazy {
        PreferenceRespository(requireContext())
    }
    private lateinit var personImageHolder : ImageView

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
        val addNewContact = view.findViewById<FloatingActionButton>(R.id.addNewContact)
        addNewContact.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.add_contact_layout)
            val spinner : Spinner = dialog.findViewById(R.id.phoneTypeSpinner)
            val personName : EditText = dialog.findViewById(R.id.personName)
            val personAddress : EditText = dialog.findViewById(R.id.personAddress)
            val personImage : ImageView = dialog.findViewById(R.id.personContactImage)
            val personEmailAddress : EditText = dialog.findViewById(R.id.personEmailAddress)
            val personNumber : EditText = dialog.findViewById(R.id.personPhoneNumber)
            val addNewContactButton : Button = dialog.findViewById(R.id.addNewContactButton)
            personImageHolder = personImage
            setupPhoneTypeSpinner(spinner)
            openGallery()
            addNewContactButton.setOnClickListener {

                if (validateInput(personName,personAddress,personEmailAddress,personNumber)){
                    Toast.makeText(context, "All Set", Toast.LENGTH_SHORT).show()

                }


            }

            dialog.show()
        }
    }

    private fun openGallery() {
        personImageHolder.setOnClickListener {
            val iGallery = Intent(Intent.ACTION_PICK)
            iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(iGallery,GALLERY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == GALLERY_REQUEST_CODE){
                personImageHolder.setImageURI(data?.data)
            }


        }
    }

    private fun validateInput(personName: EditText, personAddress: EditText, personEmailAddress: EditText, personNumber: EditText): Boolean {
        val personNameString : String = personName.text.toString().trim()
        val personAddressString : String = personAddress.text.toString().trim()
        val personEmailAddressString : String = personEmailAddress.text.toString().trim()
        val personNumberString : String = personNumber.text.toString().trim()

        if (personNameString.length <= 2){
            personName.setError("Person Name should be in 3 or more character")
            return false
        }
        if (personAddressString.length <= 9){
            personAddress.setError("Person Address should be in 10 or more character")
            return false
        }
        if (personEmailAddressString.length <= 5){
            personEmailAddress.setError("Person Email should be in 6 or more character")
            return false
        }

        if (personNumberString.length <= 9){
            personNumber.setError("Person Numder should be 10 or more character")
            return false
        }
        return true
    }

    private fun setupPhoneTypeSpinner(spinner : Spinner) {
        val phoneTypeAdapter = PhoneTypeArrayAdapter(requireContext(),PhoneTypes.phoneTypeList!!)
        spinner.adapter = phoneTypeAdapter
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

        return true
    }

    private fun contactToActivity() {
        val intent = Intent(requireContext(),MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }







}