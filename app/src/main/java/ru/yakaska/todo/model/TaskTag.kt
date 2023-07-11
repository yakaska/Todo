package ru.yakaska.todo.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(primaryKeys = ["taskId", "tagId"])
data class TaskTagXRef(
    val taskId: Long,
    val tagId: Long
)

data class TagWithTasks(
    @Embedded val tag: Tag,
    @Relation(
        parentColumn = "tagId",
        entityColumn = "taskId",
        associateBy = Junction(TaskTagXRef::class)
    )
    val tasks: List<Task>
)

data class TaskWithTags(
    @Embedded val task: Task,
    @Relation(
        parentColumn = "taskId",
        entityColumn = "tagId",
        associateBy = Junction(TaskTagXRef::class)
    )
    val tags: List<Tag>
)