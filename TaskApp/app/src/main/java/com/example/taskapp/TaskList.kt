package com.example.taskapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentCreateTaskBinding
import com.example.taskapp.databinding.FragmentTaskListBinding


class TaskList : Fragment() {

    private lateinit var binding: FragmentTaskListBinding
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var taskViewModelFactory: TaskViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_task_list,container,false)
        val application= requireNotNull(this.activity).application
        taskViewModelFactory=TaskViewModelFactory(application)
taskViewModel=ViewModelProvider(this,taskViewModelFactory).get(TaskViewModel::class.java)
        binding.createTaskButton
            .setOnClickListener{
            findNavController().navigate(R.id.action_taskList_to_createTaskFragment)
//                Log.i("hehe",taskViewModel.readAllData().toString())
        }
        binding.deleteAll.setOnClickListener{
            onDeletedfromDatabase()
        }
        taskViewModel.tasksStringZero.observe(viewLifecycleOwner) {
            binding.idTask1.text = taskViewModel.tasksStringZero.value.toString()
        }


        return binding.root
    }

    fun onDeletedfromDatabase(){
        taskViewModel.clear()
    }

}