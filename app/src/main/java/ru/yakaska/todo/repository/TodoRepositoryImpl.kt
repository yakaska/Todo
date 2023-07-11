package ru.yakaska.todo.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import ru.yakaska.todo.data.TaskDao
import ru.yakaska.todo.model.Task
import java.time.LocalDateTime
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TodoRepository {

    override fun getAll(): Flow<List<Task>> = taskDao.getAll()

}