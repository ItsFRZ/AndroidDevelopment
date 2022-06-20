package com.itsfrz.todov1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.itsfrz.todov1.R
import com.itsfrz.todov1.model.CategoryType

class SpinnerAdapter(context: Context, categoryTypeList: ArrayList<CategoryType>) :
    ArrayAdapter<CategoryType>(context, 0, categoryTypeList) {

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val categoryTypeView = getItem(position)
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.spinner_layout_items, parent, false)

        val categoryTypeImageView : ImageView = view.findViewById(R.id.spinnerItemIcon)
        val categoryTypeTextView : TextView = view.findViewById(R.id.spinnerItemText)

        categoryTypeImageView.setImageResource(categoryTypeView!!.image)
         categoryTypeTextView.text = categoryTypeView.name
        return view
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }
}