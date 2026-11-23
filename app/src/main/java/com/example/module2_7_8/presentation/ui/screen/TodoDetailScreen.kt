package com.example.module2_7_8.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.module2_7_8.presentation.viewmodel.TodoViewModel

@Composable
fun TodoDetailScreen(viewModel: TodoViewModel, todoId: Int, onBack: () -> Unit) {
    val todo = viewModel.getTodo(todoId) ?: return
    Column(modifier = Modifier.padding(16.dp)) {
        IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
        }
        Text(
            text = todo.title,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = todo.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = if (todo.isCompleted) "Выполнено" else "Не выполнено",
            color = if (todo.isCompleted) Color(0xFF2E7D32) else Color.Red,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
