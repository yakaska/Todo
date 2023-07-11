package ru.yakaska.todo.data

import android.content.Context
import androidx.room.*
import ru.yakaska.todo.data.converter.LocalDateTimeConverter
import ru.yakaska.todo.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(LocalDateTimeConverter::class)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TaskDao

    companion object {
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            if (INSTANCE == null) {
                synchronized(TodoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TodoDatabase::class.java, "todo_database"
                    ).addCallback(PrepopulateTodo(context)).build()
                }
            }
            return INSTANCE!!
        }
    }

}