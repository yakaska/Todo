package ru.yakaska.todo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.yakaska.todo.model.Task
import ru.yakaska.todo.model.TaskWithActivities

@Dao
interface TaskDao {

    @Query("SELECT * FROM todo")
    fun getAll(): Flow<List<Task>>

    @Transaction
    @Query("SELECT * FROM tasks")
    fun getTaskWithActivities(): Flow<List<TaskWithActivities>>

    @Insert
    fun insertTask(task: Task)

}
