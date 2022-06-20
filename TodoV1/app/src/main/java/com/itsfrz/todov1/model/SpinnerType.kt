package com.itsfrz.todov1.model

import com.itsfrz.todov1.R

data class CategoryType(
    val image : Int,
    val name : String
)

object CategoryTypes{

    private val images = intArrayOf(
        R.drawable.reading,
        R.drawable.ic_baseline_edit_24,
        R.drawable.ic_baseline_sports_cricket_24,
        R.drawable.ic_baseline_food_bank_24,
        R.drawable.ic_baseline_work_24,
        R.drawable.ic_baseline_fitness_center_24,
        R.drawable.cooking

    )

    private val categoryName = arrayOf<String>(
        "Reading",
        "Writing",
        "Sports",
        "Eat",
        "Work",
        "Gymming",
        "Cooking"
    )

    var categoryTypeList : ArrayList<CategoryType>? = null
        get() {
            if (field != null)
                return field
            else{
                field = ArrayList<CategoryType>()
                for (index in 0 until categoryName.size){
                    val icon : Int= images.get(index)
                    val name = categoryName[index]
                    field!!.add(CategoryType(icon,name))
                }
                return field
            }
        }
}