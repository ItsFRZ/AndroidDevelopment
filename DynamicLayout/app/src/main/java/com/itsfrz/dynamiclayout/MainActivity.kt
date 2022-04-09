package com.itsfrz.dynamiclayout

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

const val margin : Int = 16

val Int.pixel : Int
    get() = (this*Resources.getSystem().displayMetrics.density).toInt()

class MainActivity : AppCompatActivity() {

    private var questions : MutableList<Questions> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupQuestions();
        setupQuiz();
    }

    private fun setupQuiz() {
        questions.forEachIndexed{
            index,element ->
            when(element.type){
                QuestionType.Text -> {
                    setupTextQuestion(element,index);
                }
                QuestionType.Radio -> {

                }
                QuestionType.Checkbox -> {

                }


            }

        }
    }

    private fun setupTextQuestion(element: Questions, counter: Int) {
        val textView = getQuestionTextView(counter,element.qtext);


    }

    private fun getQuestionTextView(counter: Int, qtext: String): Any {
        val textView = TextView(this);
        textView.text = "Q${counter}. ${qtext}"
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = margin.pixel }

        return textView;
    }

    private fun setupQuestions() {

        questions.add(Questions(1,QuestionType.Text,"What is the capital of Nagaland",null, listOf("Kohima")))

        questions.add(Questions(2,QuestionType.Radio,"What is the largest state of India", listOf("Maharashtra","Rajasthan","Uttar Pradesh",
        "Bihar"), listOf("Rajasthan")))

        questions.add(Questions(3,QuestionType.Checkbox,"Which of these are state capital", listOf("Mumbai","Kohima","Chennai",
            "Nagpur"), listOf("Mumbai","Kohima","Chennai")))



    }
}