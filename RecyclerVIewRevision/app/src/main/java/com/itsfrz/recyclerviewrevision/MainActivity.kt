
package com.itsfrz.recyclerviewrevision

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cityList = getCityData()
        val cityRecyclerView : RecyclerView = findViewById<RecyclerView?>(R.id.cityRecyclerView)
            .apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = CityAdapter(cityList)
            }

    }


    fun getCityData() : ArrayList<City>{
        return arrayListOf(
            City(R.drawable.patna,"Patna","Patna is an ancient city that sprawls along the south bank of the Ganges River in Bihar, northeast India. The state capital, it’s home to Bihar Museum, a contemporary landmark exhibiting bronze sculptures and old coins from the region."),
            City(R.drawable.ratnagiri,"Ratnagiri","Ratnagiri is a port town in Maharashtra, western India. Overlooking the Arabian Sea, Ratnadurg Fort has the Bhagwati temple and a lighthouse. Northeast, a fish museum and aquarium includes turtles and a whale skeleton."),
            City(R.drawable.nashik,"Nashik","Nashik is an ancient holy city in Maharashtra, a state in western India. It’s known for its links to the “Ramayana” epic poem. On the Godavari River is Panchavati, a temple complex. Nearby, Lord Rama was thought to have bathed at Ram Kund water tank, today attended by Hindu devotees."),
            City(R.drawable.patna,"Patna","Patna is an ancient city that sprawls along the south bank of the Ganges River in Bihar, northeast India. The state capital, it’s home to Bihar Museum, a contemporary landmark exhibiting bronze sculptures and old coins from the region."),
            City(R.drawable.jabalpur,"Jabalpur","Jabalpur is a city in the central Indian state of Madhya Pradesh. On a rocky hilltop on the western outskirts of the city is the Madan Mahal Fort, built in 1116. Farther west, the centuries-old Pisanhari Ki Madiya Jain temple offers views of the city."),
            City(R.drawable.nashik,"Nashik","Nashik is an ancient holy city in Maharashtra, a state in western India. It’s known for its links to the “Ramayana” epic poem. On the Godavari River is Panchavati, a temple complex. Nearby, Lord Rama was thought to have bathed at Ram Kund water tank, today attended by Hindu devotees."),
            City(R.drawable.bangalore,"Bangalore","Bengaluru (also called Bangalore) is the capital of India's southern Karnataka state. The center of India's high-tech industry, the city is also known for its parks and nightlife."),
            City(R.drawable.jabalpur,"Jabalpur","Jabalpur is a city in the central Indian state of Madhya Pradesh. On a rocky hilltop on the western outskirts of the city is the Madan Mahal Fort, built in 1116. Farther west, the centuries-old Pisanhari Ki Madiya Jain temple offers views of the city."),
            City(R.drawable.nashik,"Nashik","Nashik is an ancient holy city in Maharashtra, a state in western India. It’s known for its links to the “Ramayana” epic poem. On the Godavari River is Panchavati, a temple complex. Nearby, Lord Rama was thought to have bathed at Ram Kund water tank, today attended by Hindu devotees."),
            City(R.drawable.patna,"Patna","Patna is an ancient city that sprawls along the south bank of the Ganges River in Bihar, northeast India. The state capital, it’s home to Bihar Museum, a contemporary landmark exhibiting bronze sculptures and old coins from the region."),
            City(R.drawable.ratnagiri,"Ratnagiri","Ratnagiri is a port town in Maharashtra, western India. Overlooking the Arabian Sea, Ratnadurg Fort has the Bhagwati temple and a lighthouse. Northeast, a fish museum and aquarium includes turtles and a whale skeleton."),
            City(R.drawable.jabalpur,"Jabalpur","Jabalpur is a city in the central Indian state of Madhya Pradesh. On a rocky hilltop on the western outskirts of the city is the Madan Mahal Fort, built in 1116. Farther west, the centuries-old Pisanhari Ki Madiya Jain temple offers views of the city."),
            City(R.drawable.nashik,"Nashik","Nashik is an ancient holy city in Maharashtra, a state in western India. It’s known for its links to the “Ramayana” epic poem. On the Godavari River is Panchavati, a temple complex. Nearby, Lord Rama was thought to have bathed at Ram Kund water tank, today attended by Hindu devotees."),
            City(R.drawable.shillong,"Shillong","Shillong is a hill station in northeast India and capital of the state of Meghalaya. It’s known for the manicured gardens at Lady Hydari Park.")

            )
    }



}