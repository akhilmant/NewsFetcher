package com.example.taskapp

import android.app.Application
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskapp.databinding.FragmentCreateTaskBinding
import com.example.taskapp.TaskViewModel

class CreateTaskFragment : Fragment() {

    private lateinit var binding: FragmentCreateTaskBinding

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var taskViewModelFactory: TaskViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_create_task, container, false)

        val application= requireNotNull(this.activity).application

        taskViewModelFactory = TaskViewModelFactory(application)
        taskViewModel = ViewModelProvider(this,taskViewModelFactory).get(TaskViewModel::class.java)

        binding.confirmTaskButton
            .setOnClickListener {
            insertDataToDatabase()
                val taskList=taskViewModel.readAllData()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val task = binding.taskName
            .text.toString()
        val status = binding.taskDescription
            .text.toString()

        if(inputCheck(task, status)) {
            val list = Task(0, task, status)
            taskViewModel.addTask(list)
            Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_createTaskFragment_to_taskList)
        }
    }

    private fun inputCheck(task:String,status:String):Boolean{
        return !(TextUtils.isEmpty(task)&&TextUtils.isEmpty(status))
    }

}
