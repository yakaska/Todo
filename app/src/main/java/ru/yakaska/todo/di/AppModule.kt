package ru.yakaska.todo.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.yakaska.todo.data.TaskDao
import ru.yakaska.todo.data.TodoDatabase
import ru.yakaska.todo.repository.TaskRepository
import ru.yakaska.todo.repository.TaskRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideDatabase(application: Application): TodoDatabase =
        TodoDatabase.getDatabase(application)

    @Provides
    fun provideTodoDao(database: TodoDatabase): TaskDao = database.todoDao()

    @Provides
    fun provideTodoRepository(taskDao: TaskDao): TaskRepository = TaskRepositoryImpl(taskDao)

}