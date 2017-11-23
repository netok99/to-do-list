package com.todolist.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.todolist.R
import com.todolist.core.entity.Task
import com.todolist.core.repository.TaskRepository
import java.util.*


class TaskRepository(private val context: Context) : TaskRepository {

    private val keyTask = "TASK"

    private fun getSharedPref(): SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    override fun getAllTask(): List<Task> {
        val valueKeyService = getSharedPref().getString(keyTask, String())
        if (valueKeyService!!.isEmpty()) return ArrayList()
        return Gson().fromJson<List<Task>>(valueKeyService, object : TypeToken<List<Task>>() {}.type)
    }

    override fun saveTask(task: Task) {
        val tasks = getAllTask().toMutableList()
        tasks.add(task)
        saveTaskList(tasks)
    }

    override fun deleteTask(task: Task) {
        val tasks = getAllTask().toMutableList()
        tasks.remove(task)
        saveTaskList(tasks)
    }

    private fun saveTaskList(tasks: List<Task>) {
        getSharedPref().edit().putString(keyTask, Gson().toJson(tasks)).apply()
    }
}