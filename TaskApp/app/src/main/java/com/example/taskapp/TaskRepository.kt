package com.example.taskapp

import androidx.lifecycle.LiveData
import com.example.taskapp.Task
import com.example.taskapp.TaskDao


class TaskRepository(private val taskDao: TaskDao) {
    private var allTasks=taskDao.readAllData()
    suspend fun addTask(task: Task){
        taskDao.addTask(task)
    }
    suspend fun clear(){
        taskDao.clear()
    }
     fun readAllData():LiveData<List<Task>>{
       return allTasks
    }
}