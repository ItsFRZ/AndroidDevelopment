package com.itsfrz.recyclerviewrevision

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(val cityList : ArrayList<City>) :
    RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var cityImage : ImageView = itemView.findViewById(R.id.cityImage)
         var cityName : TextView = itemView.findViewById(R.id.cityName)
         var cityDescripton : TextView = itemView.findViewById(R.id.cityDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.city_row_item,parent,false)
       return CityViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        with(holder){
            this.cityImage.setImageResource(cityList[position].cityImage)
            this.cityName.text = cityList[position].cityName
            this.cityDescripton.text = cityList[position].cityDescription
        }
    }
    override fun getItemCount(): Int = cityList.size


}