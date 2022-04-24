package com.itsfrz.androidpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BookAdapter(private val bookList : ArrayList<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val bookName : TextView = view.findViewById(R.id.bookName)
        val bookAuthor : TextView = view.findViewById(R.id.authorName)
        val bookPrice : TextView = view.findViewById(R.id.bookPrice)
        val bookImage : ImageView = view.findViewById(R.id.bookImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val bookLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_items,parent,false)
        return BookViewHolder(bookLayout)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        with(holder){
            this.bookImage.setImageResource(bookList.get(position).bookImage)
            this.bookName.text = bookList.get(position).bookName
            this.bookAuthor.text = bookList.get(position).authorName
            this.bookPrice.text = bookList.get(position).price

        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }


}
