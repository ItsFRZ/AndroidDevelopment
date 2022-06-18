package com.sriyank.spinner

import com.itsfrz.androidspinner.R

data class Country(val image: Int, val name: String)

public var load : Int = 0
public var reuse : Int = 0

object Countries {

    private val images = intArrayOf(
        R.drawable.all_countries,
        R.drawable.india,
        R.drawable.united_states,
        R.drawable.australia,
        R.drawable.united_kingdom,
        R.drawable.china
    )

    private val countries = arrayOf(
        "All Countries",
        "India",
        "USA",
        "Australia",
        "United Kingdom",
        "China"
    )

    var list: ArrayList<Country>? = null
        get() {

            if (field != null)
                load++
                return field

            field = ArrayList()
            for (i in images.indices) {

                val imageId = images[i]
                val countryName = countries[i]

                val country = Country(imageId, countryName)
                field!!.add(country)
            }
            reuse++
            return field
        }
}
