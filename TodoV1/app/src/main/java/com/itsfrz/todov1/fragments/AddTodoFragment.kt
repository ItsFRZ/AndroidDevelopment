package com.itsfrz.todov1.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.itsfrz.todov1.R
import com.itsfrz.todov1.adapter.SpinnerAdapter
import com.itsfrz.todov1.database.AppDatabase
import com.itsfrz.todov1.database.TodoModel
import com.itsfrz.todov1.model.CategoryType
import com.itsfrz.todov1.model.CategoryTypes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddTodoFragment : Fragment(), View.OnClickListener {

    val db by lazy {
        AppDatabase.getDatabase(requireContext())
    }
    private lateinit var myCalendar: Calendar
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener
    private lateinit var timeSetListener: TimePickerDialog.OnTimeSetListener

    private lateinit var taskTitle: EditText
    private lateinit var taskDescription: EditText
    private lateinit var taskDate: EditText
    private lateinit var taskTime: EditText
    private lateinit var taskSpinner: Spinner
    private lateinit var taskSaveButton: MaterialButton
    private lateinit var todoTimeReminderLayout: LinearLayout


    private lateinit var communicator: FragmentCommunicator


    var finalDate = 0L
    var finalTime = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_add_todo, container, false)
        initView(view)
        communicator = activity as FragmentCommunicator
        taskDate.setOnClickListener(this)
        taskTime.setOnClickListener(this)

        setUpSpinner()
        insertData()

        return view
    }

    private fun insertData() {

        taskSaveButton.setOnClickListener {

            if (validateInputs()) {
                val todo = TodoModel(
                    taskTitle.text.toString(),
                    taskDescription.text.toString(),
                    getSpinnerValue(taskSpinner),
                    finalDate,
                    finalTime
                )
                CoroutineScope(Dispatchers.IO).launch {
                    db.todoDao().insertTodo(todo)
                    Log.d("INSERT", "insertData: $todo")
                    
                    communicator.routeFromAddTodoToTodo()
                }
                Toast.makeText(requireContext(), "${todo}", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun getSpinnerValue(taskSpinner: Spinner): String {
        val value = taskSpinner.selectedItem
        return (value as CategoryType).name
    }


    private fun validateInputs(): Boolean {
        if (taskTitle.text.length <= 0) {
            taskTitle.setError("Title is mandatory")
            return false
        }

        if (taskDescription.text.length <= 0) {
            taskTitle.setError("Description is mandatory")
            return false
        }


        return true
    }


    private fun setUpSpinner() {
        val adapter = SpinnerAdapter(requireContext(), CategoryTypes.categoryTypeList!!)
        taskSpinner.adapter = adapter
//        Toast.makeText(requireContext(), "${taskSpinner.selectedItem}", Toast.LENGTH_SHORT).show()
    }

    private fun initView(view: View) {
        taskTitle = view.findViewById(R.id.taskTitle)
        taskDescription = view.findViewById(R.id.taskDescription)
        taskDate = view.findViewById(R.id.taskDate)
        taskTime = view.findViewById(R.id.taskTime)
        taskSpinner = view.findViewById(R.id.todoSpinner)
        taskSaveButton = view.findViewById(R.id.taskSaveButton)
        todoTimeReminderLayout = view.findViewById(R.id.todoTimeReminderLayout)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.taskDate -> {
                setListener()
            }
            R.id.taskTime -> {
                setTimeListener()
            }
        }
    }

    private fun setTimeListener() {
        myCalendar = Calendar.getInstance()
        timeSetListener =
            TimePickerDialog.OnTimeSetListener { timePicker: TimePicker, hourDay: Int, minute: Int ->
                myCalendar.set(Calendar.HOUR_OF_DAY, hourDay)
                myCalendar.set(Calendar.MINUTE, minute)
                updateTime()

            }

        val timePickerDialog = TimePickerDialog(
            requireContext(),
            timeSetListener,
            myCalendar.get(Calendar.HOUR_OF_DAY),
            myCalendar.get(Calendar.MINUTE),
            false
        )

        timePickerDialog.show()
    }

    private fun updateTime() {
        // 4:00 am/pm
        val myFormat = "h:mm a"
        val simpleDateFormat = SimpleDateFormat(myFormat)
        taskTime.setText(simpleDateFormat.format(myCalendar.time))
    }

    private fun setListener() {
        myCalendar = Calendar.getInstance()
        dateSetListener =
            DatePickerDialog.OnDateSetListener { datePicker: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDate()
            }

        val datePickerDialog = DatePickerDialog(
            requireContext(), dateSetListener,
            myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)

        )

        datePickerDialog.datePicker.minDate = System.currentTimeMillis()
        datePickerDialog.show()
    }

    private fun updateDate() {
        // EEE, 5 Jan 2020
        val myFormat = "EEE, d MM yyyy"
        val simpleDateFormat = SimpleDateFormat(myFormat)
        taskDate.setText(simpleDateFormat.format(myCalendar.time))
        todoTimeReminderLayout.visibility = View.VISIBLE

    }

}