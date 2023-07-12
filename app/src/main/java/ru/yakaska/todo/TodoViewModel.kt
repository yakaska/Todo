package ru.yakaska.todo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.yakaska.todo.model.Task
import ru.yakaska.todo.repository.TaskRepository
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TodoListUiSTate(emptyList()))

    val uiState = _uiState.asStateFlow()

    init {
        Log.d("TodoViewModel", "Init")
        viewModelScope.launch {
            taskRepository.getAll().collect { todos ->
                _uiState.value = _uiState.value.copy(tasks = todos)
            }
        }
    }

}


data class TodoListUiSTate(
    val tasks: List<Task>
)