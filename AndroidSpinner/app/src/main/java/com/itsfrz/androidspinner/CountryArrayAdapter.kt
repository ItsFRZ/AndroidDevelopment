package com.itsfrz.androidspinner

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.sriyank.spinner.Country

class CountryArrayAdapter(context : Context,countryList : ArrayList<Country>) : ArrayAdapter<Country>(context,0,countryList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    private fun initView(position : Int,convertView : View?,parent : ViewGroup) : View{
        val country = getItem(position);
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_item,parent,false)
        val countryImage : ImageView = view.findViewById(R.id.countryImage);
        val countryName = view.findViewById<TextView>(R.id.countryName)
        countryImage.setImageResource(country!!.image)
        countryName.text = country.name


        return view
    }

}