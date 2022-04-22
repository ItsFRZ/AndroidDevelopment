package com.itsfrz.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import com.itsfrz.listview.databinding.ActivityMainBinding
import com.itsfrz.listview.databinding.ActivityPrimaryBinding
import kotlin.random.Random

class PrimaryActivity : AppCompatActivity() {

    private var _binding : ActivityPrimaryBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPrimaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val allStudents : ArrayList<Student> = getDynamicStudents(100)
        val studentAdapter = StudentAdapter(this,allStudents);
        binding.studentList.adapter = studentAdapter

    }


    private fun getDynamicStudents(no : Int) : ArrayList<Student>{
        val random = Random(10);
        val studentList = ArrayList<Student>()

        for (i in 0 until no){

            val student = Student(
                studentsRollNo[random.nextInt(10)],
                studentsName[random.nextInt(10)],
                studentsAge[random.nextInt(10)],
                studentsCollege[random.nextInt(10)],
                studentsBranch[random.nextInt(10)],
                studentsAddress[random.nextInt(10)]
            )
            studentList.add(student)

        }

        return studentList
    }

    private fun getStaticStudents(): Array<Student> {
        return arrayOf(

            Student("101","Robin Utthappa","21","IIT Madras","Computer Science","Mumbai Maharashtra"),
            Student("102","Faraz Sheikh","22","GH Raisoni Univeristy","Computer Science","Nagpur Maharashtra"),
            Student("103","Alex Jones","24","National Institute of Technology","Computer Science","Pune Maharashtra"),
            Student("104","Faisal Sheikh","22","GH Raisoni Univeristy","Computer Science","Nagpur Maharashtra"),
            Student("105","Abhay Manmode","22","St Xavier Univeristy","Computer Science","NewDelhi Delhi"),
            Student("106","Asif Iqbal","24","Jaipur National Institute of Technology","Computer Science","Jaipur Rajasthan")


        )
    }






    private val studentsName = arrayOf(
        "Faraz Sheikh",
        "Faisal Sheikh",
        "Robin Uthappa",
        "John Snow",
        "Alex Jones",
        "Rishab Roy",
        "Prateek Narang",
        "Abhishek Kumar",
        "Rahul Kumar",
        "Affan Sayyad"
    )

    private val studentsAddress = arrayOf(
        "Nagpur",
        "Pune",
        "Hyderabad",
        "Chennai",
        "Mumbai",
        "Delhi",
        "New York",
        "Jaipur",
        "Bangalore",
        "Patna"
    )

    private val studentsAge = arrayOf(
        "21",
        "22",
        "23",
        "22",
        "23",
        "24",
        "22",
        "21",
        "21",
        "23"
    )

    private val studentsRollNo = arrayOf(
        "101",
        "102",
        "103",
        "104",
        "105",
        "106",
        "107",
        "108",
        "109",
        "100"
    )

    private val studentsCollege = arrayOf(
        "GHRU",
        "IIT Madras",
        "IIT Bombay",
        "NSIT",
        "NUST",
        "GHRU",
        "RNIT",
        "IIIT Hyderbad",
        "St Xavier",
        "St Paul",
    )
    private val studentsBranch= arrayOf(
        "Computer Science & Engineering",
        "Mechinical Engineering",
        "Information Technology",
        "Electronic & Electrical Engineering",
        "Civil Engineering",
        "Chemical Engineering",
        "Mining Engineering",
        "Quantum Engineering",
        "Astroscience Engineering",
        "Robotics Engineering"

        )
}