package com.example.taskapp

import androidx.room.*

@Entity(tableName = "task_table")
data class Task (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val task: String,

    val desc:String,

    )