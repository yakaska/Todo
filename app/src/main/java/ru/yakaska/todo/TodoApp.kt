package ru.yakaska.todo

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.yakaska.todo.ui.theme.TodoTheme

@Composable
fun TodoApp() {
    TodoTheme {
        Scaffold(
            bottomBar = { TodoBottomBar() },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {

                }
            },
            isFloatingActionButtonDocked = true,
            floatingActionButtonPosition = FabPosition.Center
        ) {

        }
    }
}

@Composable
fun TodoBottomBar() {
    BottomNavigation() {

        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(imageVector = Icons.Outlined.Home, contentDescription = null)
            },
            label = { Text("Home") }
        )

    }
}