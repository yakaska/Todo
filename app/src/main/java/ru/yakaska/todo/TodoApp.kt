package ru.yakaska.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.yakaska.todo.model.Task

@Composable
fun TodoApp(
    viewModel: TodoViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        contentColor = MaterialTheme.colors.onBackground,
        bottomBar = {
            TodoBottomBar()
        },
    ) {

    }

}

