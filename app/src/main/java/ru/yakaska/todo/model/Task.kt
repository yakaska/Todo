package ru.yakaska.todo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "tasks")
data class Task(
    @ColumnInfo(name = "task_id")
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val description: String,
    val status: Status,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val plannedStartDate: LocalDateTime?,
    val plannedEndDate: LocalDateTime?,
    val actualStartDate: LocalDateTime?,
    val actualEndDate: LocalDateTime?
) {
    enum class Status {
        IN_PROGRESS, DONE, OUTDATED
    }
}


