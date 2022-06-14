package com.itsfrz.employeinfocrud

import android.app.AlertDialog
import android.app.Dialog
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val LIST_UPDATE = "LIST"
    val SIZE = "SIZE"
    val SIZE_FETCH = "SIZEF"

    val employeList: ArrayList<Employe> = ArrayList();


    private lateinit var employeRecyclerView: RecyclerView
    private lateinit var employeAddButton: FloatingActionButton;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
        loadStoredData(employeList)
        setUpRecyclerView(employeRecyclerView)
        employeAdd()


    }

    private fun loadStoredData(employeList: ArrayList<Employe>) {
        val spreference : SharedPreferences = this.getPreferences(MODE_PRIVATE)
        val listSize = spreference.getInt("SIZE",0)

        Log.d(SIZE, "loadStoredData: $listSize")
        for (i in 0 until listSize){
            val outputName = spreference.getString("NAME${i}","")
            val outputGender = spreference.getString("GENDER${i}","")
            val outputAge = spreference.getString("AGE${i}","")
            val outputId = spreference.getString("ID${i}","")
            employeList.add(Employe(outputName!!,outputId!!,outputGender!!,outputAge!!))
        }
    }

    private fun setUpRecyclerView(employeRecyclerView : RecyclerView) {
        val employeAdapter = EmployeAdapter(this,employeList)
        employeRecyclerView.adapter = employeAdapter
        employeRecyclerView.layoutManager = LinearLayoutManager(this)
        employeRecyclerView.setHasFixedSize(true)
    }

    private fun setUpSpinner(inputGender : Spinner)  {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.GENDER,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        inputGender.adapter = adapter
        inputGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                Toast.makeText(this@MainActivity, "${selectedItem}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }

    private fun employeAdd() {

        employeAddButton.setOnClickListener {
            val dialog = Dialog(this@MainActivity)
            dialog.setContentView(R.layout.employe_add_layout)
            dialog.show()
            val addEmployeeButton = dialog.findViewById<Button>(R.id.addEmployeeButton)
            // employe add layout items
            val inputName = dialog.findViewById<EditText>(R.id.employeInputName)
            val inputAge = dialog.findViewById<EditText>(R.id.employeInputAge)
            val inputId = dialog.findViewById<EditText>(R.id.employeInputId)
            val inputGender: Spinner = dialog.findViewById(R.id.employeInputGender)
            setUpSpinner(inputGender)
            dialog.setCancelable(false)


            addEmployeeButton.setOnClickListener {

                val employe = Employe(
                    inputName.text.toString(),
                    inputId.text.toString(),
                    inputGender.selectedItem.toString(),
                    inputAge.text.toString()
                )


                employeList.add(employe);
                storeData(inputName.text.toString(),inputId.text.toString(),inputAge.text.toString(),inputGender.selectedItem.toString())
                Log.d(LIST_UPDATE, "employeAdd: ${employe} and list size is ${employeList.size}")
                updateRecyclerView()
                dialog.dismiss()
            }

        }


    }

    private fun storeData(inputName: String, inputId: String, inputAge: String, inputGender: String) {
        val spreference : SharedPreferences = this.getPreferences(MODE_PRIVATE)
        val listSize = spreference.getInt("SIZE",0)
        Log.d(SIZE_FETCH, "storeData: $listSize")
        val editor = spreference.edit()
        editor.putInt("SIZE",listSize+1) // counter or list size
        editor.putString("NAME${listSize}",inputName)
        editor.putString("GENDER${listSize}",inputGender)
        editor.putString("AGE${listSize}",inputAge)
        editor.putString("ID${listSize}",inputId)
        editor.commit()

    }

    private fun updateRecyclerView() {

        employeRecyclerView.adapter!!.notifyItemInserted(employeList.size-1)
        employeRecyclerView.scrollToPosition(employeList.size-1)

    }

    private fun initView() {

        employeRecyclerView = findViewById(R.id.employeeRecyclerView)
        employeAddButton = findViewById(R.id.employeAddButton)

    }


}