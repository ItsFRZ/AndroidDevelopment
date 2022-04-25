package com.itsfrz.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objectList : ArrayList<Any> = getObjectList()
        val bookAdapter = BookAdapter(objectList)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = bookAdapter
            setHasFixedSize(true)

        }



    }

    private fun getObjectList() : ArrayList<Any>{
        val catalogue : ArrayList<Any> = ArrayList()
        catalogue.addAll(getAdvertisementList())
        catalogue.addAll(getBookList())
        return catalogue.shuffled() as ArrayList<Any>
    }

    private fun getAdvertisementList() : ArrayList<Advertisment>{
        return arrayListOf(
            Advertisment("Internet Services (UCN)","Ads by Google"),
            Advertisment("Cleaning Services (Urban Clap)","Ads by Amazon"),
            Advertisment("Haldiram's Restaurant","Ads by Google"),
            Advertisment("Readers Books Studio","Ads by Facebook"),
        )
    }

    private fun getBookList(): ArrayList<Book> {
        return arrayListOf(

            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("Think Grow And Rich","Oliver Napoleon Hill ","300",R.drawable.b1),
            Book("The Da Vinci Code","Dan Brown","430",R.drawable.b6),


            )
    }

}