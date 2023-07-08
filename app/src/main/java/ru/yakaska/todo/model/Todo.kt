package ru.yakaska.todo.model

import java.time.LocalDateTime

data class Todo(
    val id: Int,
    val title: String,
    val description: String,
    val completed: Boolean,
    val createdAt: LocalDateTime,
    val expireDate: LocalDateTime
) {
    companion object {
        val Test = Todo(
            id = 0,
            title = "Test title",
            description = "Test description",
            completed = false,
            createdAt = LocalDateTime.now(),
            expireDate = LocalDateTime.now().plusDays(1)
        )
    }
}
