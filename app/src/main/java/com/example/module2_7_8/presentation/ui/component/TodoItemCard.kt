package com.example.module2_7_8.presentation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.module2_7_8.domain.model.TodoItem

@Composable
fun TodoItemCard(
    todo: TodoItem,
    onClick: () -> Unit,
    onCheckedChange: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = todo.isCompleted,
                onCheckedChange = { onCheckedChange() },
                modifier = Modifier.testTag("checkbox_${todo.id}")
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = todo.title, style = MaterialTheme.typography.titleMedium)
                Text(text = todo.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
