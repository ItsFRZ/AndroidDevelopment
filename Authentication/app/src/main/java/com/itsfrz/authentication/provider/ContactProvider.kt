package com.itsfrz.authentication.provider

import android.content.ContentResolver
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import com.itsfrz.authentication.model.Contact
import com.itsfrz.authentication.model.PersonContact


object ContactProvider {

    private val mColumnProjections = arrayOf<String>(
        ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Photo.PHOTO_THUMBNAIL_URI
    )


    public fun getContactList(context : Context) : ArrayList<Contact>{
        val contactList = ArrayList<Contact>();

        val contentResolver: ContentResolver = context.contentResolver

        val cursor : Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            mColumnProjections,
            null,
            null,
            null
        );

        cursor?.let {
            if (it.count > 0){
                while (it.moveToNext()){
                    lateinit var  contact : Contact
                    val contactId : String = it.getString(0)
                    val contactName = it.getString(1)
                    val contactNumber = it.getString(2)
                    val contactPhotoUri = it.getString(3)
                    if (contactPhotoUri == null)
                        contact = Contact(contactId,contactName,contactNumber,false,"")
                    else
                        contact = Contact(contactId,contactName,contactNumber,true,contactPhotoUri)

                    Log.d("Contact", "getContactList: Contact Information :- ${contact}")
                    contactList.add(contact)
                }
                it.close()
            }
        }


        return contactList
    }




    fun updateContact(context: Context, contactName : String, updatedContactName : String) {

        if(contactName.length > 0){
            val whereClause = ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY +"=?";
            val params = arrayOf<String>(contactName)
            val contentResolver = context.contentResolver
            val contentValues = ContentValues()
            contentValues.put(ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY,updatedContactName)
            contentResolver.update(ContactsContract.RawContacts.CONTENT_URI,contentValues,whereClause,params)
        }


//        contentResolver.update(ContactsContract.RawContacts.CONTENT_URI)

    }

    fun deleteContact(context : Context, position: Int, contactName: String) {
        val whereClause = ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY+"='"+contactName+"'"
        context.contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI,whereClause,null)
        Toast.makeText(context, "$contactName has been deleted", Toast.LENGTH_SHORT).show()
    }

    fun createContact(context: Context,personContact: PersonContact){

    }

    fun createContact(context: Context, name: String, number : String) {
        val contentValues = ContentValues()
        val uri : Uri = context.contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI,contentValues)!!
        val id = ContentUris.parseId(uri)

        val nameContentValues = ContentValues()
        nameContentValues.put(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
        nameContentValues.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME,name)
        nameContentValues.put(ContactsContract.Data.RAW_CONTACT_ID,id)
        context.contentResolver.insert(ContactsContract.Data.CONTENT_URI,nameContentValues)

        val numberContentValue = ContentValues()
        numberContentValue.put(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
        numberContentValue.put(ContactsContract.CommonDataKinds.Phone.NUMBER,number)
        numberContentValue.put(ContactsContract.Data.RAW_CONTACT_ID,id)
        context.contentResolver.insert(ContactsContract.Data.CONTENT_URI,numberContentValue)

        Toast.makeText(context, "${name} is added in contacts", Toast.LENGTH_SHORT).show()

    }


}