package com.todolist.core.repository

import com.todolist.core.entity.Task

interface TaskRepository {
    fun saveTask(task: Task)

    fun getAllTask(): List<Task>

    fun deleteTask(task: Task)
}
