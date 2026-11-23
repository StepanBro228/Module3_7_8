package com.example.module2_7_8.data.repository

import com.example.module2_7_8.data.local.TodoJsonDataSource
import com.example.module2_7_8.domain.model.TodoItem
import com.example.module2_7_8.domain.repository.TodoRepository

class TodoRepositoryImpl(private val dataSource: TodoJsonDataSource) : TodoRepository {
    private var todos: List<TodoItem>? = null

    override suspend fun getTodos(): List<TodoItem> {
        if (todos == null) {
            todos = dataSource.getTodos().map {
                TodoItem(it.id, it.title, it.description, it.isCompleted)
            }
        }
        return todos!!
    }

    override suspend fun toggleTodo(id: Int) {
        todos = getTodos().map {
            if (it.id == id) it.copy(isCompleted = !it.isCompleted) else it
        }
    }
}
