package com.todolist.data.model

import com.todolist.core.entity.Task

data class Task(private val description: String): Task {
    override fun description(): String = description
}