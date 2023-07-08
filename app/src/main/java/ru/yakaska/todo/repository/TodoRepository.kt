package ru.yakaska.todo.repository

import kotlinx.coroutines.flow.Flow
import ru.yakaska.todo.model.Todo

interface TodoRepository {

    suspend fun getTodos(): Flow<List<Todo>>

    suspend fun getTodo(id: Int): Flow<Todo?>

}