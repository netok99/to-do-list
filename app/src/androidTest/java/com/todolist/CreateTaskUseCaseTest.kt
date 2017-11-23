package com.todolist

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.todolist.core.entity.Task
import com.todolist.core.repository.TaskRepository
import com.todolist.core.usecase.CreateTaskUseCase
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateTaskUseCaseTest {

    private lateinit var taskRepository: TaskRepository
    private lateinit var useCase: CreateTaskUseCase
    private lateinit var task: Task
    private lateinit var context: Context

    @Before
    @Throws(Exception::class)
    fun setUp() {
        context = InstrumentationRegistry.getContext()
        taskRepository = com.todolist.data.repository.TaskRepository(context)
    }

    @Test
    fun createTaskUseCase() {
        val description = "test description"
        task = com.todolist.data.model.Task(description)
        useCase = CreateTaskUseCase(task, taskRepository)

        useCase.execute()

        assertEquals(taskRepository.getAllTask().size, 1)
        assertEquals(taskRepository.getAllTask()[0].description(), description)
    }
}
