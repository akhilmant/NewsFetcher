package com.example.taskapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.taskapp.Task
import com.example.taskapp.TaskDatabase
import com.example.taskapp.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application):AndroidViewModel(application) {
    private var allTasks:LiveData<List<Task>>
    private val repository: TaskRepository

    init {
        val taskDao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        allTasks=repository.readAllData()

    }

    fun addTask(task: Task){
        viewModelScope.launch (Dispatchers.IO){
            repository.addTask(task)
        }
    }
    fun clear(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.clear()
        }
    }
    fun readAllData():LiveData<List<Task>>{
        return allTasks
    }
//    val tasksStringZero=Transformations.map(allTasks)->
//        formatTask(allTasks)
//    }
val tasksStringZero = Transformations.map(allTasks) { tasks ->
    formatTask(tasks)
}
}


