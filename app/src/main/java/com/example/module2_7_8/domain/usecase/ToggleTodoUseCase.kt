package com.example.module2_7_8.domain.usecase

import com.example.module2_7_8.domain.repository.TodoRepository

class ToggleTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(id: Int) = repository.toggleTodo(id)
}
