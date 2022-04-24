package com.itsfrz.androidpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val books : ArrayList<Book> = getBookList()
        val bookAdapter = BookAdapter(books)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = bookAdapter
            setHasFixedSize(true)

        }



    }

    private fun getBookList(): ArrayList<Book> {
        return arrayListOf(

            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("Think Grow And Rich","Oliver Napoleon Hill ","300",R.drawable.b1),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("Think Grow And Rich","Oliver Napoleon Hill ","300",R.drawable.b1),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("The Da Vinci Code","Dan Brown","430",R.drawable.b6),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("The Da Vinci Code","Dan Brown","430",R.drawable.b6),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("Think Grow And Rich","Oliver Napoleon Hill ","300",R.drawable.b1),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("Think Grow And Rich","Oliver Napoleon Hill ","300",R.drawable.b1),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("The Da Vinci Code","Dan Brown","430",R.drawable.b6),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("The Da Vinci Code","Dan Brown","430",R.drawable.b6),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("Think Grow And Rich","Oliver Napoleon Hill ","300",R.drawable.b1),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("The Da Vinci Code","Dan Brown","430",R.drawable.b6),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("Think Grow And Rich","Oliver Napoleon Hill ","300",R.drawable.b1),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Richest Man In Babylon","George S. Clanson","320",R.drawable.b5),
            Book("The Da Vinci Code","Dan Brown","430",R.drawable.b6),
            Book("Wings Of Fire","Dr. APJ Abdul Kalam","550",R.drawable.b3),
            Book("Rich Dad Poor Dad","Robert T. Kiyoasaki","350",R.drawable.b4),
            Book("The Power of Subconscious Mind","Joseph Murphy","300",R.drawable.b2),

            )
    }
}