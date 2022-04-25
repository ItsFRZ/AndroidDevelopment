package com.itsfrz.androidpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList


class BookAdapter(private val objectList : ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class BookViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val bookName : TextView = view.findViewById(R.id.bookName)
        val bookAuthor : TextView = view.findViewById(R.id.authorName)
        val bookPrice : TextView = view.findViewById(R.id.bookPrice)
        val bookImage : ImageView = view.findViewById(R.id.bookImage)
    }

    class AdvertisementViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val adBanner : TextView = view.findViewById(R.id.advertisementBanner)
        val adCompany : TextView = view.findViewById(R.id.advertisementBannerCompany);
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        lateinit var holder : RecyclerView.ViewHolder
        when(viewType){
            R.layout.advertisement_row_item -> {
                val advertisementLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.advertisement_row_item,parent,false)
                holder = AdvertisementViewHolder(advertisementLayout)
            }
            R.layout.book_row_items -> {
                val bookLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.book_row_items,parent,false)
                holder = BookViewHolder(bookLayout)

            }
            else -> {
                val advertisementLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.advertisement_row_item,parent,false)
                holder = AdvertisementViewHolder(advertisementLayout)
            }
       }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder is AdvertisementViewHolder){
            with(holder){
                val adItem = objectList.get(position) as Advertisment
                this.adBanner.text = adItem.adText
                this.adCompany.text = adItem.adCompany
            }
        } else if(holder is BookViewHolder){
            with(holder){
                val bookItem = objectList.get(position) as Book
                this.bookImage.setImageResource(bookItem.bookImage)
                this.bookName.text = bookItem.bookName
                this.bookAuthor.text = bookItem.authorName
                this.bookPrice.text = bookItem.price
            }

        }


    }

    override fun getItemCount(): Int {
        return objectList.size
    }

    override fun getItemViewType(position: Int): Int {
        if (objectList.get(position) is Book)
            return R.layout.book_row_items
        else
            return R.layout.advertisement_row_item
    }
}
