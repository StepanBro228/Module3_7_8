package com.example.module2_7_8.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.module2_7_8.data.local.TodoJsonDataSource
import com.example.module2_7_8.data.repository.TodoRepositoryImpl
import com.example.module2_7_8.domain.model.TodoItem
import com.example.module2_7_8.domain.usecase.GetTodosUseCase
import com.example.module2_7_8.domain.usecase.ToggleTodoUseCase
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TodoRepositoryImpl(TodoJsonDataSource(application))
    private val getTodosUseCase = GetTodosUseCase(repository)
    private val toggleTodoUseCase = ToggleTodoUseCase(repository)

    val todos = mutableStateOf<List<TodoItem>>(emptyList())

    init {
        viewModelScope.launch {
            todos.value = getTodosUseCase()
        }
    }

    fun toggleTodo(id: Int) {
        viewModelScope.launch {
            toggleTodoUseCase(id)
            todos.value = getTodosUseCase()
        }
    }

    fun getTodo(id: Int): TodoItem? = todos.value.find { it.id == id }
}
