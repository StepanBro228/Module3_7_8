package com.example.module2_7_8.presentation.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.module2_7_8.presentation.ui.component.TodoItemCard
import com.example.module2_7_8.presentation.viewmodel.TodoViewModel

@Composable
fun TodoListScreen(viewModel: TodoViewModel, onTodoClick: (Int) -> Unit) {
    LazyColumn {
        items(viewModel.todos.value) { todo ->
            TodoItemCard(
                todo = todo,
                onClick = { onTodoClick(todo.id) },
                onCheckedChange = { viewModel.toggleTodo(todo.id) }
            )
        }
    }
}
