package com.itsfrz.todov1.fragments

import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itsfrz.todov1.R
import com.itsfrz.todov1.adapter.TodoAdapter
import com.itsfrz.todov1.database.AppDatabase
import com.itsfrz.todov1.database.TodoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoFragment : Fragment() {


    val db by lazy{
        AppDatabase.getDatabase(requireContext())
    }

    private lateinit var communicator: FragmentCommunicator
    private lateinit var addTodoPageButton : FloatingActionButton

    private val listOfTodo : ArrayList<TodoModel> = arrayListOf<TodoModel>()
    private lateinit var todoRecycler : RecyclerView
    private lateinit var adapter: TodoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.fragment_todo, container, false)
        initView(view)
        onAddTodoClick()
        communicator = activity as FragmentCommunicator
        todoRecycler = view.findViewById(R.id.todoRecyclerView)
        setUpRecyclerView()
        initSwipe()
        getAllTodo()


        return view
    }


    private fun getAllTodo() {
        db.todoDao().getUnFinishedTodo().observe(
            requireActivity()
        ) {
            if (it.isNotEmpty()) {
                listOfTodo.clear()
                listOfTodo.addAll(it)
                Log.d("LIST", "getAllTodo: $it")

                adapter.notifyDataSetChanged()
            }
        }

        Toast.makeText(requireContext(), "${listOfTodo}", Toast.LENGTH_SHORT).show()
    }

    fun initSwipe(){
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (direction == ItemTouchHelper.RIGHT){
                    CoroutineScope(Dispatchers.IO).launch {

                        db.todoDao().finishTodo(adapter.getItemId(position))
                    }
                    adapter.notifyDataSetChanged()
                }
                if(direction == ItemTouchHelper.LEFT){
                    CoroutineScope(Dispatchers.IO).launch {
                        db.todoDao().deleteTodo(adapter.getItemId(position))
                    }
                    adapter.notifyDataSetChanged()
                }

            }

            override fun onChildDraw(
                canvas: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
                    val itemView = viewHolder.itemView
                    val paint = Paint()
                    val icon :Bitmap
                    if(dX > 0){
                        icon = BitmapFactory.decodeResource(resources,R.mipmap.check_icon)
                        paint.color = Color.parseColor("#4CDB52")
                        canvas.drawRect(
                            itemView.left.toFloat(),
                            itemView.top.toFloat(),
                            itemView.right.toFloat() + dX,
                            itemView.bottom.toFloat(),paint
                        )
                        canvas.drawBitmap(
                            icon,
                            itemView.left.toFloat(),
                            itemView.top.toFloat() + (itemView.bottom.toFloat() - itemView.top.toFloat() - icon.height.toFloat())/2,
                            paint
                        )
                    }else{
                        icon = BitmapFactory.decodeResource(resources,R.mipmap.delete_icon)
                        paint.color = Color.parseColor("#FF4335")
                        canvas.drawRect(
                            itemView.left.toFloat() - dX,
                            itemView.top.toFloat(),
                            itemView.right.toFloat(),
                            itemView.bottom.toFloat(),paint
                        )
                        canvas.drawBitmap(
                            icon,
                            itemView.right.toFloat() ,
                            itemView.top.toFloat() + (itemView.bottom.toFloat() - itemView.top.toFloat() - icon.height.toFloat())/2,
                            paint
                        )
                    }
                    viewHolder.itemView.translationX = dX
                }else{

                    super.onChildDraw(
                        canvas,
                        recyclerView,
                        viewHolder,
                        dX,
                        dY,
                        actionState,
                        isCurrentlyActive
                    )
                }
            }

        }

        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(todoRecycler)
    }

    private fun setUpRecyclerView() {
        todoRecycler.layoutManager = LinearLayoutManager(requireContext())
        adapter = TodoAdapter(requireContext(), listOfTodo)
        todoRecycler.adapter = adapter
    }


    private fun onAddTodoClick() {
        addTodoPageButton.setOnClickListener {
            communicator.routeFromTodoToAddTodo()
        }
    }

    private fun initView(view : View) {
        addTodoPageButton = view.findViewById(R.id.addTodoPage)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.history -> {
                communicator.routeFromTodoToHistory()
            }

        }
        return super.onOptionsItemSelected(item)

    }


    override fun onResume() {
        super.onResume()
        (requireContext() as AppCompatActivity).supportActionBar!!.show()

    }

    override fun onPause() {
        super.onPause()
        (requireContext() as AppCompatActivity).supportActionBar!!.hide()
    }

}