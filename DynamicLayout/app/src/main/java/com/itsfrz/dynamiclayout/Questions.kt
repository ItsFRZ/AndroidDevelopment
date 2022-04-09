package com.itsfrz.dynamiclayout

enum class QuestionType {
    Text,
    Radio,
    Checkbox
}
data class Questions(val id : Int,val type : QuestionType,val qtext : String,
                    val options : List<String>? , val answer : List<String>)