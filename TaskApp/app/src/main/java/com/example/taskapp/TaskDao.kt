package com.example.taskapp

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taskapp.Task


@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Task>>

    @Query("DELETE FROM task_table ")
    fun clear()

}