package com.itsfrz.authentication.provider

import android.content.*
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import com.itsfrz.authentication.R
import com.itsfrz.authentication.model.Contact
import com.itsfrz.authentication.model.PersonContact


object ContactProvider {

    private val mColumnProjection = arrayOf<String>(
        ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
        ContactsContract.Contacts.HAS_PHONE_NUMBER,
        ContactsContract.Contacts.PHOTO_ID,
        ContactsContract.Contacts.PHOTO_THUMBNAIL_URI,
    )

    private val mColumnProjectionPhoto = arrayOf<String>(
        ContactsContract.CommonDataKinds.Phone.CONTACT_ID
    )


    public fun getContactList(context : Context) : ArrayList<Contact>{
        val contactList = ArrayList<Contact>();

        val contentResolver: ContentResolver = context.contentResolver

        val cursor : Cursor? = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            mColumnProjection,
            null,
            null,
            null
        );
//    ContactsContract.CommonDataKinds.Phone.NUMBER,

        cursor?.let {
            if (it.count > 0){
                while (it.moveToNext()){
                    val contactName = it.getString(0)
                    val contactNumber = ""
                    val hasPhoneNumber = it.getString(1).toInt()
                    val contactId = ""
                    val contact = Contact(contactName,contactNumber,false,"")
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