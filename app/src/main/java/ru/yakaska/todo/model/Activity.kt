package ru.yakaska.todo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "activities",
    foreignKeys = [
        ForeignKey(
            entity = Task::class,
            childColumns = ["task_id"],
            parentColumns = ["id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Activity(
    @ColumnInfo(name = "activity_id")
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "task_id") val taskId: Long,
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
