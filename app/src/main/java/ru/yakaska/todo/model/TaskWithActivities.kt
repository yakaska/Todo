package ru.yakaska.todo.model

import androidx.room.Embedded
import androidx.room.Relation


data class TaskWithActivities(
    @Embedded val task: Task,
    @Relation(
        parentColumn = "task_id",
        entityColumn = "activity_id",
    )
    val activities: List<Activity>
)
