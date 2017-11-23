package com.todolist.core.usecase

import com.todolist.core.entity.Task
import com.todolist.core.repository.TaskRepository

class CreateTaskUseCase(private val task: Task, private val repository: TaskRepository) {

    fun execute() = repository.saveTask(task)
}