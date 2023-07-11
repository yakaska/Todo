package ru.yakaska.todo.repository

import kotlinx.coroutines.flow.Flow
import ru.yakaska.todo.model.Task

interface TodoRepository {

    fun getAll(): Flow<List<Task>>

}